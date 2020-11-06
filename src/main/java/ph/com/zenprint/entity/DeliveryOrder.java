package ph.com.zenprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ph.com.zenprint.constant.DeliveryStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_del_order")
    private Long id;

    @Column(name = "recipient", nullable = false)
    private String recipient;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zipcode", nullable = false)
    private Integer zipcode;

    @Column(name = "barangay", nullable = false)
    private String barangay;

    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @Column(name = "note")
    private String note;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createDated;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}