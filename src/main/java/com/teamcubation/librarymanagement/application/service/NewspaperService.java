package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.INewspaperPort;
import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperService implements INewspaperPort {

    private final NewspaperManager newspaperManager;

    public NewspaperService(){
        this.newspaperManager = new NewspaperManager();
    }

    @Override
    public List<Newspaper> viewNewspaper() {
        return newspaperManager.viewNewspaper();
    }
}
