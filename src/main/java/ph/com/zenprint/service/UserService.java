package ph.com.zenprint.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ph.com.zenprint.dto.UserDto;
import ph.com.zenprint.dto.UserRequest;
import ph.com.zenprint.entity.User;
import ph.com.zenprint.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Qualifier("passwordEncoder")
    private final BCryptPasswordEncoder passwordEncoder;

    public void saveUser(UserRequest userRequest) {

        userRepository.save(User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .active(true)
                .isVerified(false)
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .storeName(userRequest.getStoreName())
                .email(userRequest.getEmail())
                .roles(userRequest.getRoles())
                .build());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private UserDto map(User user) {
        return objectMapper.convertValue(user, UserDto.class);
    }

    public Boolean isVerified(String username) {
        return userRepository.getByUsername(username)
                .isVerified();
    }
}
