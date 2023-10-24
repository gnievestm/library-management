package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
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
        assertTrue(manageEntry.addNewspaper(entry), "Successfully added");
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
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperRequest(entry), "Found a match");
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

}
