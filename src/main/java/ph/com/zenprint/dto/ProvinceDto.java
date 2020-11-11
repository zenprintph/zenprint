package ph.com.zenprint.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@Data
@Builder
public class ProvinceDto {

    private Long id;

    private String provinceName;
}