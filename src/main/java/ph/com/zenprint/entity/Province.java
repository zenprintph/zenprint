package ph.com.zenprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

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
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_province")
    private Long id;

    @Column(name = "province_name", nullable = false)
    private String provinceName;

    @OneToMany(mappedBy = "province")
    private List<City> cities;

    public Province(Long id) {
        this.id = id;
    }
}