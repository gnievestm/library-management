package com.teamcubation.librarymanagement.domain;



import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeDateVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeNameVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributesVoid;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;
import com.teamcubation.librarymanagement.service.MagazineService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    @Test
    public void MagazineTestAdd() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        MagazineService magazineService = MagazineService.getInstance();
        magazineService.addMagazine( "leo", "12-12-2002");
        Magazine magazine = new Magazine( "leo", "12-12-2002");
        boolean resultedExpected = magazineService.existMagazine(magazine);
        assertTrue(resultedExpected);
    }

    @Test
    public void MagazineTestAtributteVoid() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineAttributesVoid exception = assertThrows(MagazineAttributesVoid.class, () -> {
            magazineService.addMagazine( null, null);
        });
        assertEquals(exception.getMessage(), "Your magazine attributes are void");
    }

    @Test
    public void MagazineTestAtributteDateIsVoid() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineAttributeDateVoid exception = assertThrows(MagazineAttributeDateVoid.class, () -> {
            magazineService.addMagazine( "leo", null);
        });
        assertEquals(exception.getMessage(), "Your date for magazine is void");
    }
    @Test
    public void MagazineTestAtributteNameIsVoid() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        MagazineService magazineService = MagazineService.getInstance();
        MagazineManager MagazineManager = new MagazineManager();
        MagazineAttributeNameVoid exception = assertThrows(MagazineAttributeNameVoid.class, () -> {
            magazineService.addMagazine( null, "12-12-2002");
        });
        assertEquals(exception.getMessage(), "Your Name for magazine is void");
    }

}
