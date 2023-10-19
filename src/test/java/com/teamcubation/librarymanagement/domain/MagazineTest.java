package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.service.MagazineService;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    @Test
    public void MagazineTestAdd() throws MagazineAttributeMissingException {
        MagazineService magazineService = MagazineService.getInstance();
        boolean result = magazineService.addMagazine("leo", new Date());
        int resultedExpected = magazineService.sizeMagazine();
        assertTrue(result);
        assertEquals(resultedExpected, 1);
    }

    @Test
    public void MagazineTestAtributteVoid() {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineAttributeMissingException exception = assertThrows(MagazineAttributeMissingException.class, () -> {
            magazineService.addMagazine(null, null);
        });
        assertEquals(exception.getMessage(), "Your magazine attributes are void");
    }
}
