package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<Newspaper> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
        inUse = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline {
        try {
            if (newEntry.getDate().isEmpty() || newEntry.getHeadline().equals("")) {
                throw new MissingDateOrHeadline();
            } else {
                catalogue.add(newEntry);
            }
        } catch (MissingDateOrHeadline e) {

        }
        return true;
    }

    public void viewNewspaper() {
        System.out.println(catalogue);
    }

    public boolean viewNewspaperRequest(Newspaper entry) {

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

    public boolean returnBorrowNewspaper(Newspaper newspaper) throws NewspaperNotFound {

        if (inUse.contains(newspaper)) {
            inUse.remove(newspaper);
            catalogue.add(newspaper);
            return true;
        }
        return false;
    }

    public boolean searchForNewspaperHeadline(String headline) {

        return catalogue.stream().filter(entry -> entry.getHeadline().equals(headline)).isParallel();
    }


}
