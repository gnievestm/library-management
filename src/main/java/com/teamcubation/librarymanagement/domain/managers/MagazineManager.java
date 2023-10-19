package com.teamcubation.librarymanagement.domain.managers;


import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private List<Magazine> magazines = new ArrayList<>();
    private List<BorrowMagazine> magazinesAvailable = new ArrayList<>();
    private List<BorrowMagazine> magazinesBorrowed = new ArrayList<>();

    public List<BorrowMagazine> getMagazinesAvailable() {
        return magazinesAvailable;
    }

    public List<BorrowMagazine> getMagazinesBorrowed() {
        return magazinesBorrowed;
    }


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
    public List seeStatusMagazine() {
        List<BorrowMagazine> magazinesStatus = new ArrayList<>();

        for (int a=0;a<magazinesAvailable.size();a++)
            magazinesStatus.add(magazinesAvailable.get(a));

        for (int a=0;a<magazinesAvailable.size();a++)
            magazinesStatus.add(magazinesBorrowed.get(a));
        return magazinesStatus;
    }

    public int sizeMagazine() {
        return magazines.size();
    }

}
