package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.CityDto;
import ph.com.zenprint.service.CityService;

import java.util.List;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/{provinceId}")
    public BaseResponse<List<CityDto>> getAllCitiesByProvince(@PathVariable Long provinceId) {

        return BaseResponse.<List<CityDto>>builder()
                .code(ResponseCode.GEN200)
                .data(cityService.getAllCitiesByProvince(provinceId))
                .build();
    }
}