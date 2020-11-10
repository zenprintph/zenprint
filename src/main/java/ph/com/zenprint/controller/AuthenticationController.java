package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.AuthenticationRequest;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.service.AuthenticationService;

/**
 * @author Choy
 * @date 11/7/2020.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public BaseResponse<String> authenticate(@RequestBody AuthenticationRequest request) {
        return BaseResponse.<String>builder()
                .code(ResponseCode.GEN200)
                .data(authenticationService.authenticate(request))
                .build();
    }
}