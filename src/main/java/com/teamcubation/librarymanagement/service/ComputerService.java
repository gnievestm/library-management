package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.managers.ComputerManager;
import com.teamcubation.librarymanagement.domain.entities.Computer;
public class ComputerService {

    static ComputerService instance;

    private ComputerManager computerManager;

    public static ComputerService getInstance(){

        if(instance == null)
            instance = new ComputerService();
        return instance;
    }

    private ComputerService () {

        this.computerManager = new ComputerManager();
    }

    public void addComputer(String brand, String model) throws ComputerMissingFieldsException {


        Computer computer = new Computer(brand,model);
        this.computerManager.addComputer((computer));


    }

    public boolean existComputer(Computer computer){
        return computerManager.existComputer(computer);
    }
}
