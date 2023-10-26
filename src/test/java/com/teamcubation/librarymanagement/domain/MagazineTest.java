package com.teamcubation.librarymanagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.teamcubation.librarymanagement.application.service.MagazineService;
import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MagazineTest {

    @Test
    public void MagazineTestAdd() throws MagazineAttributeMissingException {
        MagazineService magazineService = new MagazineService();
        boolean addMagazine = magazineService.addMagazine("leo", new Date());
        int result = magazineService.magazinesCount();
        assertTrue(addMagazine);
        assertEquals(1, result);
    }

    @Test
    public void MagazineTestAttributeVoid() {
        MagazineService magazineService = new MagazineService();
        MagazineAttributeMissingException exception = assertThrows(MagazineAttributeMissingException.class, () -> {
            magazineService.addMagazine(null, null);
        });
    }

    @Test
    public void MagazineBorrowTest() throws MagazineAttributeMissingException, MagazineNotAvailableException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        int availableBeforeBorrow = magazineService.getAvailableMagazinesCount();
        int borrowedBeforeBorrow = magazineService.getBorrowedMagazinesCount();
        magazineService.borrowMagazine(magazine);
        int availableAfterBorrow = magazineService.getAvailableMagazinesCount();
        int borrowedAfterBorrow = magazineService.getBorrowedMagazinesCount();
        assertEquals(availableBeforeBorrow - 1, availableAfterBorrow);
        assertEquals(borrowedBeforeBorrow + 1, borrowedAfterBorrow);
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
        assertEquals(magazineService.searchMagazine("leo"), magazine);
    }

    @Test
    public void MagazineSearchTestException() throws MagazineAttributeMissingException, MagazineNotExistException {
        MagazineService magazineService = MagazineService.getInstance();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        MagazineNotExistException exception = assertThrows(MagazineNotExistException.class, () -> {
            magazineService.searchMagazine("no");
        });
    }

    @Test
    public void MagazineReturnTest() throws MagazineAttributeMissingException, MagazineNotAvailableException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine = new Magazine("leo", new Date());
        magazineService.addMagazine(magazine);
        magazineService.borrowMagazine(magazine);
        assertTrue(magazineService.returnMagazine(magazine));
    }
}
