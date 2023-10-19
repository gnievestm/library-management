package com.teamcubation.librarymanagement.domain.managers;


import com.teamcubation.librarymanagement.domain.entities.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private List<Magazine> magazines = new ArrayList<>();

    public List<Magazine> getMagazines() {
        return magazines;
    }


    public boolean addMagazine(Magazine magazine) {
        if (magazines.contains(magazine))
            return false;
        magazines.add(magazine);
        return true;
    }

    public boolean existMagazine(Magazine magazine) {
        return magazines.contains(magazine);
    }

    public int sizeMagazine() {
        return magazines.size();
    }

}
