package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductCode(String productCode);
    Optional<List<Product>> findByProductType(String productType);
}
