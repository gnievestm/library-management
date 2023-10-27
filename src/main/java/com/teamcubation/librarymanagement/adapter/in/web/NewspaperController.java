package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.INewspaperPort;
import com.teamcubation.librarymanagement.application.port.in.IUserPort;
import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewspaperController {

    private final INewspaperPort newspaperPort;

    public NewspaperController(INewspaperPort newspaperPort) {
        this.newspaperPort = newspaperPort;
    }

    @GetMapping(path = "/api/Newspapers")
    public ResponseEntity<List<Newspaper>> viewNewspaper() {
        return ResponseEntity.ok(newspaperPort.viewNewspaper());
    }
}
