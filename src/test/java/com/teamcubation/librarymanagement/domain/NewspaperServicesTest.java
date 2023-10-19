package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadline {

        try {
            Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
            if (entry.getDate().isEmpty() || entry.getHeadline().isEmpty()) {
                throw new MissingDateOrHeadline();
            } else {
                NewspaperManager manageEntry = new NewspaperManager();
                manageEntry.addNewspaper(entry);
            }
        } catch (MissingDateOrHeadline e) {

        }
    }

    @Test
    void viewNewspaper() {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        manageEntry.viewNewspaper();
    }

    @Test
    void viewNewspaperRequest() throws NewspaperNotFound {

        try {
            Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
            if (entry.getDate().isEmpty() || entry.getHeadline().isEmpty()) {
                throw new NewspaperNotFound();
            } else {
                NewspaperManager manageEntry = new NewspaperManager();
                manageEntry.addNewspaper(entry);

                manageEntry.viewNewspaperRequest(entry);
            }

        } catch (NewspaperNotFound e) {

        }
    }

    @Test
    void borrowNewspaper() throws NewspaperAlreadyBorrowed {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();

        assert (manageEntry.borrowNewspaper(entry));
    }
    @Test
    void borrowNewspaperException() throws NewspaperAlreadyBorrowed {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);

        assertTrue(manageEntry.borrowNewspaper(entry), "The Newspaper is successfully borrowed");
    }

    @Test
    void returnBorrowNewspaper() throws NewspaperNotFound, NewspaperAlreadyBorrowed {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        assertTrue(manageEntry.returnBorrowNewspaper(entry), "The newspaper was successfully returned");

    }

    @Test
    void searchForNewspaperHeadline(){

        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        assertTrue(manageEntry.searchForNewspaperHeadline("The Last stand"), "Found the newspaper with the headline");
    }
}