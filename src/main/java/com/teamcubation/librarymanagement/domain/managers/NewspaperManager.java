package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<Newspaper> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
        inUse = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline, NewspaperDuplicated {
        if (newEntry.getHeadline().equals("") || newEntry.getDate().equals("")){
            throw new MissingDateOrHeadline();
        } else if (catalogue.contains(newEntry)) {
            throw new NewspaperDuplicated();
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

    public boolean borrowNewspaper(Newspaper newspaper) throws NewspaperAlreadyBorrowed {
        if (inUse.contains(newspaper)) {
            throw new NewspaperAlreadyBorrowed();
        } else {
            inUse.add(newspaper);
        }
        return true;
    }

    public boolean searchForNewspaperHeadline(String headline) throws MissingDateOrHeadline, NewspaperNotFound{
        if (catalogue.stream().noneMatch(Newspaper -> Objects.equals(Newspaper.getHeadline(), headline))){
            throw new NewspaperNotFound();
        }
        return true;
    }

    public boolean returnBorrowNewspaper(Newspaper newspaper) throws NewspaperIsNotPossibleToReturn {
        if (!inUse.contains(newspaper)) {
            throw new NewspaperIsNotPossibleToReturn();
        }
        inUse.remove(newspaper);
        catalogue.add(newspaper);
        return true;
    }




}
