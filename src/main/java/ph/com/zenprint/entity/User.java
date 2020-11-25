package ph.com.zenprint.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "roles", nullable = false)
    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Package> packages;

    @OneToMany(mappedBy = "createdBy")
    private List<DeliveryOrder> deliveryOrders;

    @OneToMany(mappedBy = "soldTo")
    private List<Sale> sales;

    @Column(name = "store_name", unique = true)
    private String storeName;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createDated;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}