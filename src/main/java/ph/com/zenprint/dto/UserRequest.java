package ph.com.zenprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private Boolean active;
    private String roles;
    private String firstName;
    private String lastName;
    private String storeName;
    private String email;
}
