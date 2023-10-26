package com.teamcubation.librarymanagement.domain.entities;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidIDException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;

public class Computer {

    static int computerID = 0;
    private final String brand;
    private final String model;

    public Computer(int computerID, String brand, String model) throws ComputerMissingFieldsException, ComputerInvalidIDException {
        if (brand == null || model == null) {
            throw new ComputerMissingFieldsException();
        }
        if (computerID <= 0) {
            throw new ComputerInvalidIDException();
        }
        Computer.computerID = Computer.computerID++;
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
        return computerID == (computer.getComputerID());
    }
}
