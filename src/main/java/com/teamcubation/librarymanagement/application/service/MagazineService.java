package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IMagazinePort;
import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;
import com.teamcubation.librarymanagement.domain.managers.MagazineManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MagazineService implements IMagazinePort {
    static MagazineService instance;
    private MagazineManager magazineManager;

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

    public boolean existMagazine(int id) {
        return magazineManager.existMagazine(id);
    }

    public int magazinesCount() {
        return magazineManager.magazinesCount();
    }

    public boolean borrowMagazine(int id) throws MagazineNotAvailableException {

        return magazineManager.existMagazine(id) && this.magazineManager.borrowMagazine(id);
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

    public boolean returnMagazine(int id) {
        return magazineManager.existMagazine(id) && magazineManager.returnMagazine(id);
    }

    @Override
    public List<BorrowMagazine> getAllMagazine() {
        return this.magazineManager.getAllMagazinesAndStatus();
    }

}
