package ph.com.zenprint.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Choy
 * @date 11/25/2020.
 */

@Data
public class VariationDto {

    private Long id;

    private String code;

    private List<VariationDetailDto> variationDetails;
}