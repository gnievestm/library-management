package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class addNewspaperTest {


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
        assertFalse(manageEntry.addNewspaper(entry), "the upload the entry is negated");
    }


}
