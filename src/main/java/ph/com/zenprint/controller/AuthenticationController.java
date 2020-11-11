package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public BaseResponse<Boolean> validateToken(@RequestHeader("authorization") String authorization) {
        return BaseResponse.<Boolean>builder()
                .code(ResponseCode.GEN200)
                .data(authenticationService.validateToken(authorization))
                .build();
    }
}