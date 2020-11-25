package ph.com.zenprint.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Choy
 * @date 11/25/2020.
 */

@Data
public class VariationDetailDto {

    private Long id;

    private String variationName;

    private BigDecimal variationPrice;
}