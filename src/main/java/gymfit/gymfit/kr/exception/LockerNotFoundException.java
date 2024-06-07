package gymfit.gymfit.kr.exception;

public class LockerNotFoundException extends RuntimeException {
    public LockerNotFoundException(Long id) {
        super("Could not find locker " + id);
    }
}
