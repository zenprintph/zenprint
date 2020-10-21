package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ph.com.zenprint.entity.DefaultUserDetails;
import ph.com.zenprint.entity.User;
import ph.com.zenprint.repository.UserRepository;

import java.util.Optional;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@RequiredArgsConstructor
@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));

        return optionalUser.map(DefaultUserDetails::new).get();
    }
}