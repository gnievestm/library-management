package com.teamcubation.librarymanagement.domain;


import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineYourDoesNotExistException;
import com.teamcubation.librarymanagement.service.MagazineService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    @Test
    public void MagazineTestAdd() throws MagazineAttributeMissingException {
        MagazineService magazineService = MagazineService.getInstance();
        magazineService.addMagazine("leo", "12-12-2002");
        int resultedExpected = magazineService.sizeMagazine();
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

    @Test
    public void MagazineBorrowTest() throws MagazineYourDoesNotExistException, MagazineAttributeMissingException, MagazineNotAvailableException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", "12-12-12");
        magazineService.addMagazine(magazine);
        magazineService.addMagazineAvailable(magazine);
        assertTrue(magazineService.borrowMagazine(magazine));
    }

    @Test
    public void MagazineSeeStatusTest() throws MagazineAttributeMissingException, MagazineYourDoesNotExistException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", "12-12-12");
        magazineService.addMagazine(magazine);
        magazineService.addMagazineAvailable(magazine);
        BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, true);
        List<BorrowMagazine> expected = new ArrayList<>();
        expected.add(borrowMagazine);
        assertEquals(expected,magazineService.seeStatusMagazine());
    }

}
