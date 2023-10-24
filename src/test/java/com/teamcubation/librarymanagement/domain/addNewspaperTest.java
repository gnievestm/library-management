package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicated;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class addNewspaperTest {


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


}
