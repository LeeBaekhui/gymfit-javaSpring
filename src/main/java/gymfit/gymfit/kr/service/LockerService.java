package gymfit.gymfit.kr.service;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.Locker;
import gymfit.gymfit.kr.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LockerService {
    @Autowired
    private LockerRepository lockerRepository;

    public List<Locker> getAllLockers() {
        return lockerRepository.findAll();
    }

    public Optional<Locker> getLockerById(Long id) {
        return lockerRepository.findById(id);
    }

    public Locker createLocker(Locker locker) {
        return lockerRepository.save(locker);
    }

    public Locker updateLocker(Long id, Locker lockerDetails) {
        Locker locker = lockerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locker not found for this id :: " + id));

        locker.setCategory(lockerDetails.getCategory());
        locker.setLockerStartNumber(lockerDetails.getLockerStartNumber());
        locker.setLockerEndNumber(lockerDetails.getLockerEndNumber());
        return lockerRepository.save(locker);
    }

    public void deleteLocker(Long id) {
        Locker locker = lockerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locker not found for this id :: " + id));
        lockerRepository.delete(locker);
    }

    public List<String> getAllCategories() {
        return lockerRepository.findAll().stream()
                .map(Locker::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }
}
