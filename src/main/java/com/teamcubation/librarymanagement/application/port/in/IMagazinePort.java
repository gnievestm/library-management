package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;


import java.util.List;

public interface IMagazinePort {
    public List<BorrowMagazine> getAllMagazine();

    public Magazine searchMagazine(String name) throws MagazineNotExistException;
    public boolean addMagazine(Magazine magazine) throws MagazineAttributeMissingException;
    public boolean borrowMagazine(Magazine magazine) throws MagazineNotAvailableException;
    public boolean returnMagazine(Magazine magazine);
}
