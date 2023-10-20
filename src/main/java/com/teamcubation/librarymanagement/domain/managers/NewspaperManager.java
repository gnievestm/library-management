package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;

import java.util.ArrayList;
import java.util.List;

public class NewspaperManager {

    private List<Newspaper> catalogue;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) {
        catalogue.add(newEntry);
        return true;
    }

    public boolean viewNewspaper() {
        return !catalogue.isEmpty();
    }

    public boolean viewNewspaperRequest(Newspaper entry) throws NewspaperNotFound, MissingDateOrHeadline {

        if (entry.getDate().isEmpty() || entry.getHeadline().isEmpty()) {
            return true;
        }else {
            return catalogue.contains(entry);
        }

    }

}
