package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<Newspaper> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline {
        if (Objects.equals(newEntry.getDate(), "") || Objects.equals(newEntry.getHeadline(), "")) {
            throw new MissingDateOrHeadline();
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

    public boolean searchForNewspaperHeadline(String headline) {
        return catalogue.stream().anyMatch(Newspaper -> Objects.equals(Newspaper.getHeadline(), headline));
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
        } else {

            return false;
        }
    }


}
