package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Choy
 * @date 12/14/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ColorDto {

    private Long id;

    private String colorName;

    private String hexCode;
}
