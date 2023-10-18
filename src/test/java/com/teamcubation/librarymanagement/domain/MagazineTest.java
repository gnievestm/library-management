package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributeDateVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributeNameVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributesVoid;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    @Test
    public void MagazineTestAdd() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        Magazine magazine = new Magazine(1, "leo", "12-12-2023");
        MagazineManager seller = new MagazineManager();
        assertTrue(seller.addMagazine(magazine));
    }

    @Test
    public void MagazineTestAtributteVoid() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        Magazine magazine = new Magazine(1, null, null);
        MagazineManager seller = new MagazineManager();
        MagazineAttributesVoid exception = assertThrows(MagazineAttributesVoid.class, () -> {
            seller.addMagazine(magazine);
        });
        assertEquals(exception.getMessage(), "Your magazine attributes are void");
    }

    @Test
    public void MagazineTestAtributteDateIsVoid() throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        Magazine magazine = new Magazine(1, "leo", null);
        MagazineManager seller = new MagazineManager();
        MagazineAttributeDateVoid exception = assertThrows(MagazineAttributeDateVoid.class, () -> {
            seller.addMagazine(magazine);
        });
        assertEquals(exception.getMessage(), "Your date for magazine is void");
    }

}
