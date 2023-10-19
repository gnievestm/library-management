package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeDateMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeNameMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
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

}
