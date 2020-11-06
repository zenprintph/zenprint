package ph.com.zenprint.dto;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@Data
@Builder
public class SalesDto {

    private Long id;

    private BigDecimal grandTotal;

    private List<SalesDetailDto> salesDetails;

    @JsonSerialize(as = JsonSerializer.class)
    private LocalDateTime dtimeCreated;
}