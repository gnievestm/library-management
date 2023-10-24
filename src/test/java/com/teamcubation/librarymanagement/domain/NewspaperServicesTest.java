package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadline, NewspaperNotFound {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.addNewspaper(entry), "The upload of the entry was succeeded");
    }

    @Test
    void addNewEntryWithOutHeadlineOrDate() {

        Newspaper entry = new Newspaper(1, "", "");
        NewspaperManager manageEntry = new NewspaperManager();
        Exception thrown = Assertions.assertThrows(MissingDateOrHeadline.class, () -> {
            manageEntry.addNewspaper(entry);
        });
        assertEquals("You can´t register a Newspaper without a date or headline", thrown.getMessage());
    }

    @Test
    void viewNewspaper() throws MissingDateOrHeadline, NewspaperNotFound {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        manageEntry.viewNewspaper();
        assertTrue(manageEntry.viewNewspaper(), "Showing available newspapers");
    }

    @Test
    void viewNewspaperExist() throws MissingDateOrHeadline, NewspaperNotFound {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperExist(entry), "The newspaper exists");
    }

    @Test
    void viewNewspaperRequest() throws MissingDateOrHeadline, NewspaperNotFound {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperExist(entry), "The newspaper exist");
    }

    @Test
    void searchForNewspaperHeadline() throws MissingDateOrHeadline, NewspaperNotFound {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.searchForNewspaperHeadline("The last stand"), "Found the newspaper with the headline");
    }

    @Test
    void searchForNewspaperHeadlineException() throws MissingDateOrHeadline, NewspaperNotFound {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        Exception thrown = assertThrows(NewspaperNotFound.class, () -> {
            manageEntry.searchForNewspaperHeadline("He´s back");
        });

        assertEquals("There is not a newspaper with this data", thrown.getMessage());
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

        assert (manageEntry.borrowNewspaper(entry));
    }

    @Test
    void returnBorrowNewspaper() throws NewspaperNotFound {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.returnBorrowNewspaper(entry);
    }


}
