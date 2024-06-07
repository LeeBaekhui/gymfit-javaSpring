package gymfit.gymfit.kr.repository;

import gymfit.gymfit.kr.model.LockerPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerPositionRepository extends JpaRepository<LockerPosition, Long> {
}
