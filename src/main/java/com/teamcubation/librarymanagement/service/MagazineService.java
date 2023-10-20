package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.*;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;

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

    public void addMagazine(String magazineName, String date) throws MagazineAttributeNameMissingException, MagazineAttributeMissingException, MagazineAttributeDateMissingException {
        if (magazineName == null && date == null && magazineName == "" && date == "") {
            throw new MagazineAttributeMissingException();
        }
        if (magazineName == null && magazineName == "") {
            throw new MagazineAttributeNameMissingException();
        }
        if (date == null && date == "") {
            throw new MagazineAttributeDateMissingException();
        }
        Magazine magazine = new Magazine(magazineName, date);
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
            return addMagazineAvailable(magazine);
        }
        throw new MagazineYourDoesNotExistException();
    }
    public boolean borrowMagazine(Magazine magazine) throws MagazineYourDoesNotExistException {
        if(magazineManager.existMagazine(magazine)){
            return borrowMagazine(magazine);
        }
        throw new MagazineYourDoesNotExistException();
    }



}
