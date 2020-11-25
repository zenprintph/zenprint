package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Variation;

/**
 * @author Choy
 * @date 11/25/2020.
 */
@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {
}