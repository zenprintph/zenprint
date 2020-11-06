package ph.com.zenprint.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@Data
@Builder
public class ProductDto {

    private String productName;

    private BigDecimal unitPrice;
}