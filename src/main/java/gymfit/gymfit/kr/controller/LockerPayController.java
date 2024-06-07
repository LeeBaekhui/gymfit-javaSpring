package gymfit.gymfit.kr.controller;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.LockerPay;
import gymfit.gymfit.kr.service.LockerPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lockerPays")
public class LockerPayController {
    @Autowired
    private LockerPayService lockerPayService;

    @GetMapping
    public List<LockerPay> getAllLockerPays() {
        return lockerPayService.getAllLockerPays();
    }

    @GetMapping("/{id}")
    public LockerPay getLockerPayById(@PathVariable Long id) {
        return lockerPayService.getLockerPayById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPay not found for this id :: " + id));
    }

    @PostMapping
    public LockerPay createLockerPay(@RequestBody LockerPay lockerPay) {
        return lockerPayService.createLockerPay(lockerPay);
    }

    @PutMapping("/{id}")
    public LockerPay updateLockerPay(@PathVariable Long id, @RequestBody LockerPay lockerPayDetails) {
        return lockerPayService.updateLockerPay(id, lockerPayDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLockerPay(@PathVariable Long id) {
        lockerPayService.deleteLockerPay(id);
    }
}
