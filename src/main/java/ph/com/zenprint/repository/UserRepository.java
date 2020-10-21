package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.com.zenprint.entity.User;

import java.util.Optional;

/**
 * @author Choy
 * @date 10/22/2020.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
