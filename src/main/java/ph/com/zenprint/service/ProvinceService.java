package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.ProvinceDto;
import ph.com.zenprint.repository.ProvinceRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@RequiredArgsConstructor
@Service
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    public List<ProvinceDto> getAllProvinces() {
        return provinceRepository.findAll()
                .stream().map(province -> ProvinceDto.builder()
                        .id(province.getId())
                        .provinceName(province.getProvinceName())
                        .build())
                .collect(Collectors.toList());
    }
}