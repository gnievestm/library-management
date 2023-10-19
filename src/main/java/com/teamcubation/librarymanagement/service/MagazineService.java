package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeDateVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeNameVoid;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributesVoid;
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

    public void addMagazine(String magazineName, String date) throws MagazineAttributeNameVoid, MagazineAttributesVoid, MagazineAttributeDateVoid {
        if (magazineName == null && date == null) {
            throw new MagazineAttributesVoid();
        }
        if (magazineName == null) {
            throw new MagazineAttributeNameVoid();
        }
        if (date == null) {
            throw new MagazineAttributeDateVoid();
        }
        Magazine magazine = new Magazine(magazineName, date);
        this.magazineManager.addMagazine(magazine);
    }

    public boolean existMagazine(Magazine magazine) {
        return magazineManager.existMagazine(magazine);
    }
}
