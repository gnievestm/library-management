package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;


import java.util.List;

public interface IMagazinePort {
    List<BorrowMagazine> getAllMagazine();

    Magazine searchMagazine(String name) throws MagazineNotExistException;

    boolean addMagazine(Magazine magazine) throws MagazineAttributeMissingException;

    boolean borrowMagazine(int id) throws MagazineNotAvailableException;

    boolean returnMagazine(int id);
}
