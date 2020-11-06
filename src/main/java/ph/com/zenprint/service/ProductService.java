package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.ProductDto;
import ph.com.zenprint.entity.Product;
import ph.com.zenprint.exception.NotFoundException;
import ph.com.zenprint.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto getProductByCode(String productCode) {

        Optional<Product> optionalProduct = productRepository
                .findByProductCode(productCode);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return mapToProductDto(product);
        }

        throw NotFoundException.Error.PRODUCT_NOT_FOUND.create();
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream().map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .productName(product.getProductName())
                .unitPrice(product.getUnitPrice())
                .build();
    }
}