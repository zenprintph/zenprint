package ph.com.zenprint.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ph.com.zenprint.constant.ShirtPrintLocation;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class PrintLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_print_location")
    private Long id;

    @Column(name = "print_location")
    private ShirtPrintLocation shirtPrintLocation;

    @Column(name = "num_colors")
    private Integer numberOfColors;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}
