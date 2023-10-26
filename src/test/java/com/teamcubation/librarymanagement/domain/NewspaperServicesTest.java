package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperIsNotPossibleToReturn;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicated;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadline, NewspaperDuplicated {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.addNewspaper(entry), "The upload of the entry was succeeded");
    }
    @Test
    void addNewEntryWithOutHeadlineOrDate() throws MissingDateOrHeadline {

        Newspaper entry = new Newspaper(1, "", "");
        NewspaperManager manageEntry = new NewspaperManager();
        Exception thrown = Assertions.assertThrows(MissingDateOrHeadline.class, () -> {
            manageEntry.addNewspaper(entry);
        });
        assertEquals("You can´t register a Newspaper without a date or headline", thrown.getMessage());
    }
    @Test
    void addNewEntryDuplicated() throws MissingDateOrHeadline, NewspaperDuplicated {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        Exception thrown = Assertions.assertThrows(NewspaperDuplicated.class, () -> {
            manageEntry.addNewspaper(entry);
        });
        assertEquals("You can´t add a entry that already exist", thrown.getMessage());
    }
    @Test
    void viewNewspaper() throws MissingDateOrHeadline, NewspaperDuplicated {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        manageEntry.viewNewspaper();
        assertTrue(manageEntry.viewNewspaper(), "Showing available newspapers");
    }

    @Test
    void viewNewspaperExist() throws MissingDateOrHeadline, NewspaperDuplicated {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperExist(entry), "The newspaper exists");
    }

    @Test
    void searchForNewspaperHeadline() throws MissingDateOrHeadline, NewspaperNotFound, NewspaperDuplicated {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.searchForNewspaperHeadline("The last stand"), "Found the newspaper with the headline");
    }
    @Test
    void searchForNewspaperHeadlineException() throws MissingDateOrHeadline, NewspaperNotFound, NewspaperDuplicated {
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
        assertTrue(manageEntry.borrowNewspaper(entry), "The Newspaper is successfully borrowed");
    }

    @Test
    void borrowNewspaperException() throws NewspaperAlreadyBorrowed {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        Exception thrown = assertThrows(NewspaperAlreadyBorrowed.class, () ->{
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
