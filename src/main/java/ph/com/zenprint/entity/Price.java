package ph.com.zenprint.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Choy
 * @date 5/3/2021.
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price")
    private Long id;

    @Column(name = "num_colors", unique = true)
    private Integer numberOfColors;

    @Column(name = "thirty_pieces")
    private Integer thirtyPieces;

    @Column(name = "fifty_pieces")
    private Integer fiftyPieces;

    @Column(name = "one_hundred_pieces")
    private Integer oneHundredPieces;

    @Column(name = "two_hundred_pieces")
    private Integer twoHundredPieces;

    @Column(name = "three_hundred_pieces")
    private Integer threeHundredPieces;

    @Column(name = "four_hundred_pieces")
    private Integer fourHundredPieces;

    @Column(name = "five_hundred_pieces")
    private Integer fiveHundredPieces;

    @CreationTimestamp
    @Column(name = "dtime_created")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "dtime_updated")
    private LocalDateTime updatedDate;
}
