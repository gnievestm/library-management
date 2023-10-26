package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerManager {
    private List<Computer> computerList;

    public ComputerManager() {
        computerList = new ArrayList<>();
    }

    public boolean addComputer(Computer computer) {

        if (computerList.contains(computer))
            return false;

        computerList.add(computer);
        return true;
    }

    public boolean existComputer(Computer computer) {
        return computerList.contains(computer);
    }

    public List<Computer> showComputers() {
        return new ArrayList<>(computerList);
    }


}
