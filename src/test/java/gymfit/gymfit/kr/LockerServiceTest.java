package gymfit.gymfit.kr.service;

import gymfit.gymfit.kr.model.Locker;
import gymfit.gymfit.kr.repository.LockerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LockerServiceTest {
    @Mock
    private LockerRepository lockerRepository;

    @InjectMocks
    private LockerService lockerService;

    @Test
    public void testFindById() {
        Locker locker = new Locker();
        locker.setId(1L);
        when(lockerRepository.findById(1L)).thenReturn(Optional.of(locker));

        Locker found = lockerService.findById(1L);
        assertEquals(found.getId(), locker.getId());
    }

    @Test
    public void testSaveLocker() {
        Locker locker = new Locker();
        when(lockerRepository.save(locker)).thenReturn(locker);

        Locker saved = lockerService.save(locker);
        verify(lockerRepository, times(1)).save(locker);
    }
}