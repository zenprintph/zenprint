package ph.com.zenprint.dto;

import lombok.Data;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@Data
public class AuthenticationRequest {

    private String username;

    private String password;
}