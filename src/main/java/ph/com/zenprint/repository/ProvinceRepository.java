package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Province;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
