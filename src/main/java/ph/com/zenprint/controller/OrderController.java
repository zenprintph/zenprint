package ph.com.zenprint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.OrderRequest;

/**
 * @author Choy
 * @date 4/19/2021.
 */

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final ObjectMapper mapper;

    @PostMapping(value = "/test")
    public BaseResponse<Object> test(@RequestPart("shirtDesignFile") MultipartFile shirtDesignFile,
                                     MultipartFile necktapeDesignFile,
                                     MultipartFile packagingDesignFile,
                                     @RequestPart("obj") Object obj) {

        var orderRequest = mapper.convertValue(obj, OrderRequest.class);

        return BaseResponse.builder()
                .code(ResponseCode.GEN200)
                .data(orderRequest)
                .build();
    }
}
