package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.UserRequest;
import ph.com.zenprint.entity.User;
import ph.com.zenprint.repository.UserRepository;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Qualifier("passwordEncoder")
    private final BCryptPasswordEncoder passwordEncoder;

    public User saveUser(UserRequest userRequest) {

        return userRepository.save(User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .active(true)
                .roles(userRequest.getRoles())
                .build());
    }
}