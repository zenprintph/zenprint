package ph.com.zenprint.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.VariationDto;
import ph.com.zenprint.entity.Variation;
import ph.com.zenprint.repository.VariationRepository;

/**
 * @author Choy
 * @date 11/25/2020.
 */

@RequiredArgsConstructor
@Service
public class VariationService {

    private final VariationRepository variationRepository;
    private final ObjectMapper mapper;

    public void addVariation(VariationDto request) {

        Variation variation = mapper.convertValue(request, Variation.class);

        variationRepository.save(variation);
    }
}