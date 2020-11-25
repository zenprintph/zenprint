package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.util.List;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {

    private String productName;

    private BigDecimal unitPrice;

    private List<VariationDto> variations;
}