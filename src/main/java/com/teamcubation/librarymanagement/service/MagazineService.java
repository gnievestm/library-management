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
    private MagazineManager magazineManager;

    public static MagazineService getInstance() {
        if (instance == null)
            instance = new MagazineService();
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

    public int sizeMagazine() {
        return magazineManager.sizeMagazine();
    }

    public int sizeMagazineStatus() {
        return magazineManager.sizeMagazineStatus();
    }

    public boolean addMagazineAvailable(Magazine magazine) {
        if (magazineManager.existMagazine(magazine)) {
            return this.magazineManager.addMagazineAvailable(magazine);
        }
        return false;
    }

    public void borrowMagazine(Magazine magazine) throws MagazineNotAvailableException {
        if (magazineManager.existMagazine(magazine)) {
            this.magazineManager.borrowMagazine(magazine);
        }
    }

    public List seeStatusMagazine() {
        return this.magazineManager.seeStatusMagazine();
    }
    public Magazine searchMagazine(String name) throws MagazineNotExistException {
        return magazineManager.searchMagazine(name);
    }
    public boolean returnMagazine(Magazine magazine){
        if (magazineManager.existMagazine(magazine)) {
     return magazineManager.returnMagazine(magazine);
        }
        return false;
    }
}
