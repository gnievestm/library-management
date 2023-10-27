package com.teamcubation.librarymanagement.domain;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;
import com.teamcubation.librarymanagement.application.service.ComputerService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerServiceTest {

    @Test
    void addComputerTest() throws ComputerMissingFieldsException, ComputerAlreadyExistsException {
        ComputerService computerService = new ComputerService();
        computerService.addComputer("brand", "model");
        boolean found = computerService.existComputer(1);

        assertTrue(found);
    }

    @Test
    void addComputerNullTest() {

        assertThrows(ComputerMissingFieldsException.class, () -> {
            ComputerService computerService = new ComputerService();
            computerService.addComputer(null, "model");
        });
    }

    @Test
    void viewComputerTest() throws ComputerMissingFieldsException, ComputerAlreadyExistsException {

        ComputerService cs = new ComputerService();
        List<String> computers = cs.getAllComputers();
        int expectedSizeBeforeAdding = 0;
        assertEquals(expectedSizeBeforeAdding, computers.size());
        cs.addComputer("brand", "model");
        int expectedSizeAfterAdding = 1;
        computers = cs.getAllComputers();
        assertEquals(expectedSizeAfterAdding, computers.size());
    }

    @Test
    void reserveComputer() throws ComputerMissingFieldsException, ComputerNotAvailableException, ComputerAlreadyExistsException{
        ComputerService cs = new ComputerService();
        cs.addComputer("brand", "model");
        cs.reserveComputer(1);
        int expectedAvailable = 0;
        assertEquals(expectedAvailable, cs.getAllAvailableComputers().size());
    }
}
