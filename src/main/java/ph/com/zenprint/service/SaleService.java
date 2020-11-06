package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.ProductDto;
import ph.com.zenprint.dto.SalesDetailDto;
import ph.com.zenprint.dto.SalesDto;
import ph.com.zenprint.entity.Sale;
import ph.com.zenprint.entity.SalesDetail;
import ph.com.zenprint.entity.User;
import ph.com.zenprint.exception.NotFoundException;
import ph.com.zenprint.repository.SaleRepository;
import ph.com.zenprint.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@RequiredArgsConstructor
@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final UserRepository userRepository;

    public List<SalesDto> getSalesByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return saleRepository.findAllBySoldTo(user.get())
                    .stream().map(sale -> SalesDto.builder()
                            .grandTotal(sale.getGrandTotal())
                            .id(sale.getId())
                            .salesDetails(mapSalesDto(sale))
                            .dtimeCreated(sale.getCreateDated())
                            .build()).collect(Collectors.toList());
        }

        throw NotFoundException.Error.SALES_NOT_FOUND.create();
    }

    private List<SalesDetailDto> mapSalesDto(Sale sale) {
        return sale.getSalesDetails().stream()
                .map(salesDetail -> SalesDetailDto.builder()
                .id(salesDetail.getId())
                .product(mapProductDto(salesDetail))
                .quantity(salesDetail.getQuantity())
                .subtotal(salesDetail.getSubtotal())
                .build())
                .collect(Collectors.toList());
    }

    private ProductDto mapProductDto(SalesDetail salesDetail) {
        return ProductDto.builder()
                .unitPrice(salesDetail.getProduct().getUnitPrice())
                .productName(salesDetail.getProduct().getProductName())
                .build();
    }
}