package gymfit.gymfit.kr.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "locker_pays")
@Getter
@Setter
public class LockerPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lockerPayCategory;

    @Column(nullable = false)
    private String lockerPayName;

    @Column(nullable = false)
    private int lockerPayTerm;

    @Column(nullable = false)
    private int lockerPayMargin;

    @Column(nullable = false)
    private int lockerPayPrice;

    @Column(nullable = false)
    private int lockerPayLateFee;

    @Column(nullable = false)
    private String lockerPayLateFeeState;
}
