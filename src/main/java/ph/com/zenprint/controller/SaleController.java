package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.SalesDto;
import ph.com.zenprint.service.SaleService;

import java.util.List;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping("/get-sales")
    public BaseResponse<List<SalesDto>> getSalesByUsername(@RequestHeader("username") String username) {

        return BaseResponse.<List<SalesDto>>builder()
                .code(ResponseCode.GEN200)
                .data(saleService.getSalesByUsername(username))
                .build();
    }
}