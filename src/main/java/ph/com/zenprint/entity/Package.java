package ph.com.zenprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Choy
 * @date 11/3/2020.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_package")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany
    @JoinTable(name = "package_product", joinColumns = @JoinColumn(name = "id_package"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    @Column(name = "num_quantity", nullable = false)
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createDated;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}