package ph.com.zenprint.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Choy
 * @date 11/6/2020.
 */
@Builder
@Data
public class SalesDetailDto {

    private Long id;

    private BigDecimal subtotal;

    private ProductDto product;

    private Integer quantity;
}