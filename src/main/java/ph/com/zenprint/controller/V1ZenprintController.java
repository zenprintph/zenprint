package ph.com.zenprint.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ph.com.zenprint.dto.UserRequest;
import ph.com.zenprint.service.UserService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class V1ZenprintController implements ZenprintController {

    private final UserService userService;

    @Override
    public String getUsers() {
        log.info("ADMIN");
        return "THIS IS ADMIN HOMIE";
    }

    @Override
    public String getGenericUsers() {
        return "JUST A USER BRAH";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        return "Successfully registered : " + userRequest.getUsername();
    }

    @GetMapping("/")
    public String yey() {
        return "YEY";
    }
}
