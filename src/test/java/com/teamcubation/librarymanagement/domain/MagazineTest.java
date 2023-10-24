package com.teamcubation.librarymanagement.domain;


import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;
import com.teamcubation.librarymanagement.service.MagazineService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void MagazineBorrowTest() throws MagazineAttributeMissingException, MagazineNotAvailableException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        magazineService.borrowMagazine(magazine);
        assertEquals(magazineService.sizeMagazineStatus(), 1);
    }

    @Test
    public void MagazineSeeStatusTest() throws MagazineAttributeMissingException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, true);
        List<BorrowMagazine> expected = new ArrayList<>();
        expected.add(borrowMagazine);
        assertEquals(expected, magazineService.seeStatusMagazine());
    }
    @Test
    public void MagazineSearchTest() throws MagazineAttributeMissingException, MagazineNotExistException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        assertEquals(magazineService.searchMagazine("leo"),magazine);
    }
    @Test
    public void MagazineSearchTestExceptiom() throws MagazineAttributeMissingException, MagazineNotExistException  {
        MagazineService magazineService = MagazineService.getInstance();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        MagazineNotExistException exception = assertThrows(MagazineNotExistException.class, () -> {
            magazineService.searchMagazine("no");
        });
        assertEquals(exception.getMessage(), "The magazine does not exist");
    }
}
