package ph.com.zenprint.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.ColorDto;
import ph.com.zenprint.repository.ColorRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@RequiredArgsConstructor
@Service
public class ColorService {

    private final ColorRepository colorRepository;

    private final ObjectMapper mapper;

    public List<ColorDto> getAllColors() {
        return colorRepository.findAll()
                .stream()
                .map(color -> mapper.convertValue(color, ColorDto.class))
                .collect(Collectors.toList());
    }
}
