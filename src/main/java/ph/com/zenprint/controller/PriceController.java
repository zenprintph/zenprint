package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.PriceDto;
import ph.com.zenprint.service.EmailService;
import ph.com.zenprint.service.PriceService;

import java.time.LocalDateTime;

/**
 * @author Choy
 * @date 5/3/2021.
 */

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final EmailService emailService;

    @PostMapping("/shirt")
    public BaseResponse<PriceDto> getShirtPrice(@RequestBody PriceDto price) {

        return BaseResponse.<PriceDto>builder()
                .code(ResponseCode.GEN200)
                .data(priceService.getShirtPrice(price.getQuantity(), price.getNumberOfColors()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
