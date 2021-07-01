package ph.com.zenprint.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ph.com.zenprint.constant.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Choy
 * @date 4/19/2021.
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "job_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "shirt_subtotal")
    private BigDecimal shirtSubtotal;

    @Column(name = "packaging_subtotal")
    private BigDecimal packagingSubtotal;

    @Column(name = "etiketa_subtotal")
    private BigDecimal etiketaSubtotal;

    @Column(name = "necktape_subtotal")
    private BigDecimal necktapeSubtotal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<Shirt> shirts;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private Packaging packaging;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<Etiketa> etiketas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<SysFile> designFiles;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}
