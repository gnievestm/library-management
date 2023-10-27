package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.INewspaperPort;
import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadlineException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicatedException;
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
    public boolean addNewspaper(Newspaper newspaper) throws MissingDateOrHeadlineException, NewspaperDuplicatedException {
        return newspaperManager.addNewspaper(newspaper);
    }

    @Override
    public List<Newspaper> viewNewspaper() {
        return newspaperManager.viewNewspaper();
    }
}
