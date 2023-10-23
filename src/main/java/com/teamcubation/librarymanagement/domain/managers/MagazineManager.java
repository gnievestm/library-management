package com.teamcubation.librarymanagement.domain.managers;


import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private List<Magazine> magazines = new ArrayList<>();
    private List<BorrowMagazine> magazinesAvailable = new ArrayList<>();
    private List<BorrowMagazine> magazinesBorrowed = new ArrayList<>();
    private List<BorrowMagazine> magazinesStatus = new ArrayList<>();

    public List<BorrowMagazine> getMagazinesStatus() {return magazinesStatus;}

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

        for (int a = 0; a < magazinesAvailable.size(); a++)
            magazinesStatus.add(magazinesAvailable.get(a));

        for (int a = 0; a < magazinesBorrowed.size(); a++)
            magazinesStatus.add(magazinesBorrowed.get(a));

        return magazinesStatus;
    }

    public int sizeMagazine() {
        return magazines.size();
    }


    public boolean borrowMagazine(Magazine magazine) throws MagazineNotAvailableException {
        for (int index = 0; index < magazinesAvailable.size(); index++) {
            BorrowMagazine borrowMagazineAvailable = new BorrowMagazine(magazine, true);
            if (magazinesAvailable.contains(borrowMagazineAvailable)) {
                magazinesAvailable.remove(borrowMagazineAvailable);
                BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, false);
                magazinesBorrowed.add(borrowMagazine);
                return true;
            }
        }
        throw new MagazineNotAvailableException();
    }

    public boolean addMagazineAvailable(Magazine magazine) {
        BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, true);
        magazinesAvailable.add(borrowMagazine);
        return true;
    }
}

