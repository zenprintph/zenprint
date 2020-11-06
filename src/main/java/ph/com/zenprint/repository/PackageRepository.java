package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Package;

/**
 * @author Choy
 * @date 11/3/2020.
 */
@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
}
