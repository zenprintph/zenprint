package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.UserDto;
import ph.com.zenprint.dto.UserRequest;
import ph.com.zenprint.service.EmailService;
import ph.com.zenprint.service.UserService;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class V1ZenprintController {

    private final UserService userService;
    private final EmailService emailService;

    @PostMapping("/register")
    public BaseResponse<Object> register(@RequestBody UserRequest userRequest) {
        try {
            userService.saveUser(userRequest);
            emailService.generateEmailConfirmation(userRequest.getUsername());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Username %s already exist",
                    userRequest.getUsername()));
        }
        return BaseResponse.builder()
                .code(ResponseCode.GEN200)
                .build();
    }

    @GetMapping("/users")
    public BaseResponse<List<UserDto>> getAllUsers() {
        return BaseResponse.<List<UserDto>>builder()
                .code(ResponseCode.GEN200)
                .data(userService.getAllUsers())
                .build();
    }
}
