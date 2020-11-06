package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.Sale;
import ph.com.zenprint.entity.User;

import java.util.List;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllBySoldTo(User user);
}
