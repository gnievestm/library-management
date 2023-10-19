package com.teamcubation.librarymanagement.domain.managers;


import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeDateVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeNameVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributesVoid;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private List<Magazine> magazines = new ArrayList<>();
    public List<Magazine> getMagazines() {
        return magazines;
    }

    public MagazineManager() {
        this.magazines = magazines;
    }

    public boolean addMagazine(Magazine magazine) throws MagazineAttributesVoid, MagazineAttributeDateVoid, MagazineAttributeNameVoid {
        if(magazines.contains(magazine))
            return false;
        magazines.add(magazine);
        return true;
    }
    public boolean existMagazine(Magazine magazine){
        return magazines.contains(magazine);
    }

}
