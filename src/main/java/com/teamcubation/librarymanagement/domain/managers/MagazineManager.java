package com.teamcubation.librarymanagement.domain.managers;


import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributeDateVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributeNameVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazie.MagazineAttributesVoid;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private List<Magazine> magazines = new ArrayList<>();
    public List<Magazine> getMagazines() {
        return magazines;
    }

    public MagazineManager() {
    }

    public MagazineManager(List<Magazine> magazines) {
        this.magazines = magazines;
    }

    public boolean addMagazine(Magazine magazine) throws MagazineAttributesVoid, MagazineAttributeDateVoid, MagazineAttributeNameVoid {
        if (magazine.getDate() == null && magazine.getName() == null) {
            throw new MagazineAttributesVoid();
        }
        if (magazine.getName() == null) {
            throw new MagazineAttributeNameVoid();
        }
        if (magazine.getDate() == null) {
            throw new MagazineAttributeDateVoid();
        }
        magazines.add(magazine);
        return true;
    }

}
