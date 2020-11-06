package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Color;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
