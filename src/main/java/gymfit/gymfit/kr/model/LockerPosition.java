package gymfit.gymfit.kr.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "locker_positions")
@Getter
@Setter
public class LockerPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lockerPositionCategory;

    @Column(nullable = false)
    private int lockerPositionWidth;

    @Column(nullable = false)
    private int lockerPositionHeight;

    @Column(nullable = false)
    private String lockerPositionName;
}
