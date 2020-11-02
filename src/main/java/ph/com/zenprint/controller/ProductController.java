package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.ProductDto;
import ph.com.zenprint.service.ProductService;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public BaseResponse<ProductDto> getProducts () {

        return BaseResponse.<ProductDto>builder()
                .code(ResponseCode.GEN200)
                .build();
    }
}