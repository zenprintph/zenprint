package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.constant.DeliveryStatus;
import ph.com.zenprint.entity.DeliveryOrder;

import java.util.List;

/**
 * @author Choy
 * @date 11/3/2020.
 */
@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {

    List<DeliveryOrder> findByStatus(DeliveryStatus status);
}
