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

    public List<BorrowMagazine> getMagazinesStatus() {
        return magazinesStatus;
    }

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
        if (!magazinesAvailable.contains(magazine)) {
            addMagazineAvailable(magazine);
        }
        return true;
    }

    public boolean existMagazine(Magazine magazine) {
        return magazines.contains(magazine);
    }

    public List seeStatusMagazine() {
        return magazinesStatus;
    }

    public int sizeMagazine() {
        return magazines.size();
    }

    public int sizeMagazineStatus() {
        return magazinesStatus.size();
    }


    public void borrowMagazine(Magazine magazine) throws MagazineNotAvailableException {
        BorrowMagazine borrowMagazineAvailable = new BorrowMagazine(magazine, true);
        if (magazinesStatus.contains(borrowMagazineAvailable)) {
            magazinesAvailable.remove(borrowMagazineAvailable);
            magazinesBorrowed.add(new BorrowMagazine(magazine, false));
            for (int index = 0; index < magazinesStatus.size(); index++) {
                magazinesStatus.get(index).setBorrow(false);
            }
            return;
        }
        throw new MagazineNotAvailableException();
    }

    public boolean addMagazineAvailable(Magazine magazine) {
        BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, true);
        magazinesAvailable.add(borrowMagazine);
        magazinesStatus.add(borrowMagazine);
        return true;
    }
}

