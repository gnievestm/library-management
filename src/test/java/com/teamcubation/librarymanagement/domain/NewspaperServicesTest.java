package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadline {

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
    void viewNewspaper() throws MissingDateOrHeadline {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        manageEntry.viewNewspaper();
        assertTrue(manageEntry.viewNewspaper(), "Showing available newspapers");
    }

    @Test
    void viewNewspaperExist() throws MissingDateOrHeadline{
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperExist(entry), "The newspaper exists");
    }


}
