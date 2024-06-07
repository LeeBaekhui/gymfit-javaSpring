package gymfit.gymfit.kr.controller;

import gymfit.gymfit.kr.exception.ResourceNotFoundException;
import gymfit.gymfit.kr.model.Locker;
import gymfit.gymfit.kr.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lockers")
public class LockerController {
    @Autowired
    private LockerService lockerService;

    @GetMapping
    public List<Locker> getAllLockers() {
        return lockerService.getAllLockers();
    }

    @GetMapping("/{id}")
    public Locker getLockerById(@PathVariable Long id) {
        return lockerService.getLockerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locker not found for this id :: " + id));
    }

    @PostMapping
    public Locker createLocker(@RequestBody Locker locker) {
        return lockerService.createLocker(locker);
    }

    @PutMapping("/{id}")
    public Locker updateLocker(@PathVariable Long id, @RequestBody Locker lockerDetails) {
        return lockerService.updateLocker(id, lockerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLocker(@PathVariable Long id) {
        lockerService.deleteLocker(id);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return lockerService.getAllCategories();
    }
}
