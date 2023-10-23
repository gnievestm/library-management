package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.*;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;

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

    public void addMagazine(String magazineName, String date) throws MagazineAttributeMissingException {
        if (magazineName == null || date == null || magazineName == "" || date == "") {
            throw new MagazineAttributeMissingException();
        }
        Magazine magazine = new Magazine(magazineName, date);
        this.magazineManager.addMagazine(magazine);
    }
    public void addMagazine(Magazine magazine) throws  MagazineAttributeMissingException{
        if (magazine.getName() == null || magazine.getDate() == null || magazine.getName() == "" || magazine.getDate() == "") {
            throw new MagazineAttributeMissingException();
        }
        this.magazineManager.addMagazine(magazine);
    }

    public boolean existMagazine(Magazine magazine) {
        return magazineManager.existMagazine(magazine);
    }

    public int sizeMagazine() {
        return magazineManager.sizeMagazine();
    }
    public boolean addMagazineAvailable(Magazine magazine) throws MagazineYourDoesNotExistException {
        if(magazineManager.existMagazine(magazine)){
            return this.magazineManager.addMagazineAvailable(magazine);
        }
        throw new MagazineYourDoesNotExistException();
    }
    public boolean borrowMagazine(Magazine magazine) throws MagazineYourDoesNotExistException, MagazineNotAvailableException {
        if(magazineManager.existMagazine(magazine)){
            return this.magazineManager.borrowMagazine(magazine);
        }
        throw new MagazineYourDoesNotExistException();
    }
    public List seeStatusMagazine() {
        return this.magazineManager.seeStatusMagazine();
    }
}
