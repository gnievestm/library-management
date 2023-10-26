package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<Newspaper> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
        inUse = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadlineException, NewspaperDuplicatedException {
        if (newEntry.getHeadline().equals("") || newEntry.getDate().equals("")){
            throw new MissingDateOrHeadlineException();
        } else if (catalogue.contains(newEntry)) {
            throw new NewspaperDuplicatedException();
        }
        catalogue.add(newEntry);
        return true;
    }

    public boolean viewNewspaper() {
        return !catalogue.isEmpty();
    }

    public boolean viewNewspaperExist(Newspaper entry) {
        return catalogue.contains(entry);
    }

    public boolean borrowNewspaper(Newspaper newspaper) throws NewspaperAlreadyBorrowedException {
        if (inUse.contains(newspaper)) {
            throw new NewspaperAlreadyBorrowedException();
        } else {
            inUse.add(newspaper);
        }
        return true;
    }

    public boolean searchForNewspaperHeadline(String headline) throws MissingDateOrHeadlineException, NewspaperNotFoundException {
        if (catalogue.stream().noneMatch(Newspaper -> Objects.equals(Newspaper.getHeadline(), headline))){
            throw new NewspaperNotFoundException();
        }
        return true;
    }

    public boolean returnBorrowNewspaper(Newspaper newspaper) throws NewspaperIsNotPossibleToReturnException {
        if (!inUse.contains(newspaper)) {
            throw new NewspaperIsNotPossibleToReturnException();
        }
        inUse.remove(newspaper);
        catalogue.add(newspaper);
        return true;
    }



}
