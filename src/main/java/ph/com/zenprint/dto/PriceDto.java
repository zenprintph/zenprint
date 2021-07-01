package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Choy
 * @date 5/3/2021.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

    private Integer quantity;
    private Integer numberOfColors;
    private Integer unitPrice;
}
