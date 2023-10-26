package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;

import java.util.ArrayList;
import java.util.List;

public class MagazineManager {

    private List<Magazine> magazines = new ArrayList<>();
    private List<Magazine> magazinesAvailable = new ArrayList<>();
    private List<Magazine> magazinesBorrowed = new ArrayList<>();
    private List<BorrowMagazine> magazinesStatus = new ArrayList<>();

    public List<BorrowMagazine> getMagazinesStatus() {
        return magazinesStatus;
    }

    public List<Magazine> getMagazinesAvailable() {
        return magazinesAvailable;
    }

    public List<Magazine> getMagazinesBorrowed() {
        return magazinesBorrowed;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public boolean addMagazine(Magazine magazine) {

        if (magazines.contains(magazine)) return false;

        magazines.add(magazine);
        addMagazineAvailable(magazine);

        return true;
    }

    public boolean existMagazine(Magazine magazine) {
        return magazines.contains(magazine);
    }

    public List<BorrowMagazine>getAllMagazinesAndStatus() {
        return magazinesStatus;
    }

    public int magazinesCount() {
        return magazines.size();
    }

    public boolean borrowMagazine(Magazine magazine) throws MagazineNotAvailableException {
        magazinesAvailable.remove(magazine);
        magazinesBorrowed.add(magazine);

        for (BorrowMagazine status : magazinesStatus) {
            if (status.getMagazine().equals(magazine)) {
                status.setBorrow(false);
                return true;
            }
        }
        return false;
    }

    private boolean addMagazineAvailable(Magazine magazine) {
        BorrowMagazine borrowMagazine = new BorrowMagazine(magazine, true);
        magazinesAvailable.add(magazine);
        magazinesStatus.add(borrowMagazine);
        return true;
    }

    public Magazine searchMagazine(String name) throws MagazineNotExistException {
        for (int index = 0; index < magazines.size(); index++) {
            if (magazines.get(index).getName().equals(name)) {
                return magazines.get(index);
            }
        }
        throw new MagazineNotExistException();
    }

    public boolean returnMagazine(Magazine magazine) {

        magazinesAvailable.add(magazine);
        magazinesBorrowed.remove(magazine);

        for (BorrowMagazine status : magazinesStatus) {
            if (status.getMagazine().equals(magazine)) {
                status.setBorrow(true);
                return true;
            }
        }
        return false;
    }
}
