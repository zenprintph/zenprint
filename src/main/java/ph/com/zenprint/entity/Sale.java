package ph.com.zenprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Choy
 * @date 11/6/2020.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long id;

    @OneToMany(mappedBy = "sale")
    private List<SalesDetail> salesDetails;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User soldTo;

    @Column(name = "grand_total", nullable = false)
    private BigDecimal grandTotal;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createDated;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}