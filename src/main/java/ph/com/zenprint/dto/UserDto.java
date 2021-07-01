package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Choy
 * @date 4/19/2021.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean active;
    private LocalDateTime createdDate;
}
