package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.com.zenprint.entity.Price;

/**
 * @author Choy
 * @date 5/3/2021.
 */
public interface PriceRepository extends JpaRepository<Price, Long> {

    Price findByNumberOfColors(Integer numberOfColors);
}
