package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperIsNotPossibleToReturn;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadline {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.addNewspaper(entry), "The upload of the entry was succeeded");
    }

    @Test
    void addNewEntryWithOutHeadlineOrDate() throws MissingDateOrHeadline {

        Newspaper entry = new Newspaper(1, "", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.addNewspaper(entry), "the upload the entry is negated");
    }

    @Test
    void viewNewspaper() throws MissingDateOrHeadline {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        manageEntry.viewNewspaper();
    }

    @Test
    void viewNewspaperRequest() throws NewspaperNotFound, MissingDateOrHeadline {

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
    void searchForNewspaperHeadline() throws MissingDateOrHeadline {

        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        assertTrue(manageEntry.searchForNewspaperHeadline("The Last stand"), "Found the newspaper with the headline");
    }

    @Test
    void borrowNewspaper() throws NewspaperAlreadyBorrowed, NewspaperIsNotPossibleToReturn {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assert (manageEntry.borrowNewspaper(entry));
    }

    @Test
    void borrowNewspaperException() throws NewspaperAlreadyBorrowed, NewspaperIsNotPossibleToReturn {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        Exception thrown = assertThrows(NewspaperAlreadyBorrowed.class, () -> {
            manageEntry.borrowNewspaper(entry);
        });
        assertEquals("This newspaper is not available", thrown.getMessage());
    }

    @Test
    void returnBorrowNewspaper() throws NewspaperAlreadyBorrowed, NewspaperIsNotPossibleToReturn {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        assertTrue(manageEntry.returnBorrowNewspaper(entry), "The newspaper was successfully returned");
    }

    @Test
    void returnBorrowNewspaperException() throws NewspaperAlreadyBorrowed, NewspaperIsNotPossibleToReturn {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        Newspaper entry2 = new Newspaper(2, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        Exception thrown = assertThrows(NewspaperIsNotPossibleToReturn.class, () -> {
            manageEntry.returnBorrowNewspaper(entry2);
        });
        assertEquals("There are not need to return a Newspaper", thrown.getMessage());
    }
}
