package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.INewspaperPort;
import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadlineException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicatedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewspaperController {

    private final INewspaperPort newspaperPort;

    public NewspaperController(INewspaperPort newspaperPort) {
        this.newspaperPort = newspaperPort;
    }

    @PostMapping(path = "/api/AddNewspapers")
    public ResponseEntity<Boolean> addNewspaper(@RequestBody Newspaper newspaper) throws MissingDateOrHeadlineException, NewspaperDuplicatedException {
        return ResponseEntity.ok(newspaperPort.addNewspaper(newspaper));
    }

    @GetMapping(path = "/api/Newspapers")
    public ResponseEntity<List<Newspaper>> viewNewspaper() {
        return ResponseEntity.ok(newspaperPort.viewNewspaper());
    }
}
