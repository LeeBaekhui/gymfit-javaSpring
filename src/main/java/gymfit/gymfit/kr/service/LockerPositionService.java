package gymfit.gymfit.kr.service;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.LockerPosition;
import gymfit.gymfit.kr.repository.LockerPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LockerPositionService {
    @Autowired
    private LockerPositionRepository lockerPositionRepository;

    public List<LockerPosition> getAllLockerPositions() {
        return lockerPositionRepository.findAll();
    }

    public Optional<LockerPosition> getLockerPositionById(Long id) {
        return lockerPositionRepository.findById(id);
    }

    public LockerPosition createLockerPosition(LockerPosition lockerPosition) {
        return lockerPositionRepository.save(lockerPosition);
    }

    public LockerPosition updateLockerPosition(Long id, LockerPosition lockerPositionDetails) {
        LockerPosition lockerPosition = lockerPositionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPosition not found for this id :: " + id));

        lockerPosition.setLockerPositionCategory(lockerPositionDetails.getLockerPositionCategory());
        lockerPosition.setLockerPositionWidth(lockerPositionDetails.getLockerPositionWidth());
        lockerPosition.setLockerPositionHeight(lockerPositionDetails.getLockerPositionHeight());
        lockerPosition.setLockerPositionName(lockerPositionDetails.getLockerPositionName());

        return lockerPositionRepository.save(lockerPosition);
    }

    public void deleteLockerPosition(Long id) {
        LockerPosition lockerPosition = lockerPositionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPosition not found for this id :: " + id));
        lockerPositionRepository.delete(lockerPosition);
    }
}
