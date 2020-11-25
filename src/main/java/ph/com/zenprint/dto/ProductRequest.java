package ph.com.zenprint.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Choy
 * @date 11/25/2020.
 */

@Data
public class ProductRequest {

    private String productName;

    private BigDecimal unitPrice;

    private String productCode;

    private String productType;
}