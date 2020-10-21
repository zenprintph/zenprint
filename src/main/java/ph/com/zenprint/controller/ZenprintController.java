package ph.com.zenprint.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface ZenprintController {

    @GetMapping("/admin/users")
    String getUsers();

    @GetMapping("/user/users")
    String getGenericUsers();
}
