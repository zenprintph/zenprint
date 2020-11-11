package ph.com.zenprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author Choy
 * @date 11/11/2020.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "zipcode")
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "id_province")
    private Province province;
}