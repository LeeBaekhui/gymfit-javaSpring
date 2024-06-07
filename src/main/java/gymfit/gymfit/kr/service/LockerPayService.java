package gymfit.gymfit.kr.service;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.LockerPay;
import gymfit.gymfit.kr.repository.LockerPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LockerPayService {
    @Autowired
    private LockerPayRepository lockerPayRepository;

    public List<LockerPay> getAllLockerPays() {
        return lockerPayRepository.findAll();
    }

    public Optional<LockerPay> getLockerPayById(Long id) {
        return lockerPayRepository.findById(id);
    }

    public LockerPay createLockerPay(LockerPay lockerPay) {
        return lockerPayRepository.save(lockerPay);
    }

    public LockerPay updateLockerPay(Long id, LockerPay lockerPayDetails) {
        LockerPay lockerPay = lockerPayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPay not found for this id :: " + id));

        lockerPay.setLockerPayCategory(lockerPayDetails.getLockerPayCategory());
        lockerPay.setLockerPayName(lockerPayDetails.getLockerPayName());
        lockerPay.setLockerPayTerm(lockerPayDetails.getLockerPayTerm());
        lockerPay.setLockerPayMargin(lockerPayDetails.getLockerPayMargin());
        lockerPay.setLockerPayPrice(lockerPayDetails.getLockerPayPrice());
        lockerPay.setLockerPayLateFee(lockerPayDetails.getLockerPayLateFee());
        lockerPay.setLockerPayLateFeeState(lockerPayDetails.getLockerPayLateFeeState());

        return lockerPayRepository.save(lockerPay);
    }

    public void deleteLockerPay(Long id) {
        LockerPay lockerPay = lockerPayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPay not found for this id :: " + id));
        lockerPayRepository.delete(lockerPay);
    }
}
