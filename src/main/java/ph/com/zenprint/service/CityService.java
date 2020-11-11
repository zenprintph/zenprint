package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.CityDto;
import ph.com.zenprint.entity.Province;
import ph.com.zenprint.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 11/11/2020.
 */
@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    public List<CityDto> getAllCitiesByProvince(Long provinceId) {
        return cityRepository.findAllByProvince(new Province(provinceId))
                .stream().map(city -> CityDto.builder()
                        .id(city.getId())
                        .cityName(city.getCityName())
                        .zipcode(city.getZipcode())
                        .build())
                .collect(Collectors.toList());
    }
}