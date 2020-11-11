package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.ProvinceDto;
import ph.com.zenprint.service.ProvinceService;

import java.util.List;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/province")
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping
    public BaseResponse<List<ProvinceDto>> getAllProvinces() {

        return BaseResponse.<List<ProvinceDto>>builder()
                .code(ResponseCode.GEN200)
                .data(provinceService.getAllProvinces())
                .build();
    }
}