package ph.com.zenprint.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@Data
@Builder
public class UserRequest {

    private String username;

    private String password;

    private Boolean active;

    private String roles;
}