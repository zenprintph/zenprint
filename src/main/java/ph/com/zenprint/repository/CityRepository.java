package ph.com.zenprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.zenprint.entity.City;
import ph.com.zenprint.entity.Province;

import java.util.List;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByProvince(Province province);
}
