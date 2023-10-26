package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;

import java.util.Date;

public class MagazineService {
    static MagazineService instance;
    private final MagazineManager magazineManager;

    public static MagazineService getInstance() {
        if (instance == null)
            instance = new MagazineService();
        return instance;
    }


    public MagazineService() {

        this.magazineManager = new MagazineManager();
    }

    public boolean addMagazine(String magazineName, Date date) throws MagazineAttributeMissingException {
        if (magazineName == null || date == null || magazineName.isEmpty()) {
            throw new MagazineAttributeMissingException();
        }

        Magazine magazine = new Magazine(magazineName, date);
        return this.magazineManager.addMagazine(magazine);
    }

    public boolean existMagazine(Magazine magazine) {
        return magazineManager.existMagazine(magazine);
    }

    public int sizeMagazine() {
        return magazineManager.magazinesCount();
    }

}
