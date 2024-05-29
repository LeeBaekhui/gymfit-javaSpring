package gymfit.gymfit.kr.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "members")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberGroup;

    @Column(nullable = false)
    private Float bmi;

    @Column(nullable = false)
    private String lockerNumber;

    @Column(nullable = false)
    private String handler;

    @Column(nullable = false)
    private String enterAlarm;

    @Column(nullable = false)
    private String address;

    @Column
    private String memo;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] profileImage;

}
