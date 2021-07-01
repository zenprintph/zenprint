package ph.com.zenprint.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Choy
 * @date 4/21/2021.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {

    private List<ObjDto> shirtVariations;
}
