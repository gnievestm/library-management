package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IComputerPort;
import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExists;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {

    private final IComputerPort computerPort;

    public ComputerController(IComputerPort computerPort) {
        this.computerPort = computerPort;
    }

   @PostMapping(path = "/api/computers")
    public ResponseEntity<Computer> addComputer (@RequestBody Computer computer) throws ComputerMissingFieldsException,ComputerAlreadyExists {
        computerPort.addComputer(computer);
        return ResponseEntity.ok(computer);
   }

   @GetMapping(path = "/api/computers")
    public ResponseEntity<List<String>> getAllComputers() {
        return ResponseEntity.ok(computerPort.getAllComputers());
   }

   @GetMapping(path = "/api/computersAvailable")
    public ResponseEntity<List<String>> getAllAvailableComputers(){
        return ResponseEntity.ok(computerPort.getAllAvailableComputers());
   }

   @PostMapping(path = "/api/computersReserve/{id}")
   public ResponseEntity<Computer> reserveComputer(@PathVariable("id") int computerId) throws ComputerNotAvailableException {
       Computer reservedComputer = computerPort.reserveComputer(computerId);
       return ResponseEntity.ok(reservedComputer);
   }
}
