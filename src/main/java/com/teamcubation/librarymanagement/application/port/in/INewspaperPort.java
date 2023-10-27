package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadlineException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicatedException;

import java.util.List;

public interface INewspaperPort {

    public boolean addNewspaper(Newspaper newspaper) throws MissingDateOrHeadlineException, NewspaperDuplicatedException;
    public List<Newspaper> viewNewspaper();
}
