package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ph.com.zenprint.constant.ShirtSize;

/**
 * @author Choy
 * @date 4/21/2021.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjDto {

    private Integer quantity;
    private ShirtSize size;
    private ColorDto color;
}
