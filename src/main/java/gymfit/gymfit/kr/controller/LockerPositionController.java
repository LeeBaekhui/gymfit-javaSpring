package gymfit.gymfit.kr.controller;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.LockerPosition;
import gymfit.gymfit.kr.service.LockerPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lockerPositions")
public class LockerPositionController {
    @Autowired
    private LockerPositionService lockerPositionService;

    @GetMapping
    public List<LockerPosition> getAllLockerPositions() {
        return lockerPositionService.getAllLockerPositions();
    }

    @GetMapping("/{id}")
    public LockerPosition getLockerPositionById(@PathVariable Long id) {
        return lockerPositionService.getLockerPositionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LockerPosition not found for this id :: " + id));
    }

    @PostMapping
    public LockerPosition createLockerPosition(@RequestBody LockerPosition lockerPosition) {
        return lockerPositionService.createLockerPosition(lockerPosition);
    }

    @PutMapping("/{id}")
    public LockerPosition updateLockerPosition(@PathVariable Long id, @RequestBody LockerPosition lockerPositionDetails) {
        return lockerPositionService.updateLockerPosition(id, lockerPositionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLockerPosition(@PathVariable Long id) {
        lockerPositionService.deleteLockerPosition(id);
    }
}
