package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;

import java.util.Date;
import java.util.List;

public class MagazineService {
    static MagazineService instance;
    private final MagazineManager magazineManager;

    public static MagazineService getInstance() {
        if (instance == null) instance = new MagazineService();
        return instance;
    }


    public MagazineService() {
        this.magazineManager = new MagazineManager();
    }

    public boolean addMagazine(String magazineName, Date date) throws MagazineAttributeMissingException {
        if (magazineName == null || date == null || magazineName == "") {
            throw new MagazineAttributeMissingException();
        }
        Magazine magazine = new Magazine(magazineName, date);

        return this.magazineManager.addMagazine(magazine);

    }

    public boolean addMagazine(Magazine magazine) throws MagazineAttributeMissingException {
        if (magazine.getName() == null || magazine.getDate() == null || magazine.getName() == "") {
            throw new MagazineAttributeMissingException();
        }
        return this.magazineManager.addMagazine(magazine);
    }

    public boolean existMagazine(Magazine magazine) {
        return magazineManager.existMagazine(magazine);
    }

    public int magazinesCount() {
        return magazineManager.magazinesCount();
    }

    public boolean borrowMagazine(Magazine magazine) throws MagazineNotAvailableException {
        return magazineManager.existMagazine(magazine) && this.magazineManager.borrowMagazine(magazine);
    }

    public int getAvailableMagazinesCount() {
        return magazineManager.getMagazinesAvailable().size();
    }

    public int getBorrowedMagazinesCount() {
        return magazineManager.getMagazinesBorrowed().size();
    }

    public List seeStatusMagazine() {
        return this.magazineManager.getAllMagazinesAndStatus();
    }

    public Magazine searchMagazine(String name) throws MagazineNotExistException {
        return magazineManager.searchMagazine(name);
    }

    public boolean returnMagazine(Magazine magazine) {
        return magazineManager.existMagazine(magazine) && magazineManager.returnMagazine(magazine);
    }
}
