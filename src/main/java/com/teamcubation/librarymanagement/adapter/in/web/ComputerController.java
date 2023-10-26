package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IComputerPort;
import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExists;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidID;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerController {

    private final IComputerPort computerPort;

    public ComputerController(IComputerPort computerPort) {
        this.computerPort = computerPort;
    }

   @PostMapping(path = "/api/computers")
    public ResponseEntity<Computer> addComputer (@RequestBody Computer computer) throws ComputerMissingFieldsException, ComputerInvalidID, ComputerAlreadyExists {
        computerPort.addComputer(computer);
        return ResponseEntity.ok(computer);
   }

}
