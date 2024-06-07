package gymfit.gymfit.kr.repository;

import gymfit.gymfit.kr.model.LockerPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerPayRepository extends JpaRepository<LockerPay, Long> {
}
