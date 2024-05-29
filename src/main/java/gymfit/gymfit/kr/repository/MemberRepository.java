package gymfit.gymfit.kr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gymfit.gymfit.kr.model.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
