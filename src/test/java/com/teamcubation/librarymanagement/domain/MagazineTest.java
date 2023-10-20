package com.teamcubation.librarymanagement.domain;



import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeDateMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeNameMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineYourDoesNotExistException;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;
import com.teamcubation.librarymanagement.service.MagazineService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    @Test
    public void MagazineTestAdd() throws MagazineAttributeNameMissingException, MagazineAttributeMissingException, MagazineAttributeDateMissingException {
        MagazineService magazineService = MagazineService.getInstance();
        magazineService.addMagazine( "leo", "12-12-2002");
        int resultedExpected = magazineService.sizeMagazine();
        assertEquals(resultedExpected,1);

    }

    @Test
    public void MagazineTestAtributteVoid() {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineAttributeMissingException exception = assertThrows(MagazineAttributeMissingException.class, () -> {
            magazineService.addMagazine( null, null);
        });
        assertEquals(exception.getMessage(), "Your magazine attributes are void");
    }

    @Test
    public void MagazineTestAtributteDateIsVoid()  {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineAttributeDateMissingException exception = assertThrows(MagazineAttributeDateMissingException.class, () -> {
            magazineService.addMagazine( "leo", null);
        });
        assertEquals(exception.getMessage(), "Your date for magazine is void");
    }
    @Test
    public void MagazineTestAtributteNameIsVoid() {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineManager MagazineManager = new MagazineManager();
        MagazineAttributeNameMissingException exception = assertThrows(MagazineAttributeNameMissingException.class, () -> {
            magazineService.addMagazine( null, "12-12-2002");
        });
        assertEquals(exception.getMessage(), "Your Name for magazine is void");
    }
    @Test
    public void MagazineBorrowTest() throws MagazineYourDoesNotExistException, MagazineAttributeDateMissingException, MagazineAttributeNameMissingException, MagazineAttributeMissingException {
        MagazineService magazineService = new MagazineService();
        Magazine magazine =new Magazine("leo","12-12-12");
        magazineService.addMagazine("leo","12-12-12");
        magazineService.addMagazineAvailable(magazine);
        assertTrue(magazineService.borrowMagazine(magazine));
    }

}
