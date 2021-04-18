package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Choy
 * @date 12/27/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileDto {

    private String fileName;

    private Long fileSize;

    private String fileType;

    private String base64String;
}
