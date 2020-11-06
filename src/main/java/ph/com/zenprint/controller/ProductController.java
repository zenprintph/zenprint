package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.ProductDto;
import ph.com.zenprint.service.ProductService;

import java.util.List;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/zenprint/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public BaseResponse<ProductDto> getProductByCode (@RequestParam("code") String code) {

        return BaseResponse.<ProductDto>builder()
                .code(ResponseCode.GEN200)
                .data(productService.getProductByCode(code))
                .build();
    }

    @GetMapping("/all")
    public BaseResponse<List<ProductDto>> getAllProducts() {
        return BaseResponse.<List<ProductDto>>builder()
                .code(ResponseCode.GEN200)
                .data(productService.getAllProducts())
                .build();
    }
}