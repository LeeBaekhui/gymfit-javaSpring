package gymfit.gymfit.kr.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private int lockerStartNumber;
    private int lockerEndNumber;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
