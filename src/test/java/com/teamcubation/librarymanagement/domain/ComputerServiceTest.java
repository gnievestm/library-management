package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidIDException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.managers.ComputerManager;
import com.teamcubation.librarymanagement.service.ComputerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class ComputerServiceTest {

    @Test
    void adduserTest() throws ComputerInvalidIDException, ComputerMissingFieldsException {
        ComputerService computerService = ComputerService.getInstance();
        computerService.addComputer(1, "brand", "model");
        Computer computer = new Computer(1, "brand", "model");
        boolean found = computerService.existComputer(computer);

        assertTrue(found);
    }

    @Test
    void addComputerNullTest() {

        assertThrows(ComputerMissingFieldsException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(1, null, "model");
                });
    }

    @Test
    void negativeIDTest() {

        assertThrows(ComputerInvalidIDException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(-1, "brand", "model");
                });
    }

    @Test
    void idZeroTest() {

        assertThrows(ComputerInvalidIDException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(0, "brand", "model");
                });
    }
    @Test
    void testShowComputers() throws ComputerMissingFieldsException, ComputerInvalidIDException {

        ComputerService computerService = ComputerService.getInstance();
        computerService.addComputer(1,"brand","model");
        computerService.addComputer(3,"brand2","model2");

        ComputerManager computerManager = new ComputerManager();

        Computer computer1 = new Computer(1, "brand","model");
        Computer computer2 = new Computer(3, "brand2","model2");

        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);

        List<Computer> computerList = computerManager.showComputers();

        assertTrue(computerList.contains(computer1));
        assertTrue(computerList.contains(computer2));
        assertEquals(2, computerList.size());

    }


}
