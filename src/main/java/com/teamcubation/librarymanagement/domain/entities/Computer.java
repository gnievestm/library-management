package com.teamcubation.librarymanagement.domain.entities;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidID;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidID;

public class Computer {

    private int computerID = 0;
    private String brand;
    private String model;
    
    public Computer(int computerID, String brand, String model) throws ComputerMissingFieldsException, ComputerInvalidID {
        if (brand == null || model == null) {
            throw new ComputerMissingFieldsException();
        }
        if (computerID <= 0) {
            throw new ComputerInvalidID();
        }
        this.computerID = computerID;
        this.brand = brand;
        this.model = model;
    }

    public int getComputerID() {
        return computerID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return computerID == (computer.computerID) && brand.equals(computer.brand) && model.equals(computer.model);
    }
}
