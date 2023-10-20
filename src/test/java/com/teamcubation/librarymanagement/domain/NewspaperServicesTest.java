package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
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
    void viewNewspaper() throws MissingDateOrHeadline {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaper(), "Showing available newspapers");
    }

    @Test
    void viewNewspaperRequest() throws NewspaperNotFound, MissingDateOrHeadline {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperRequest(entry), "Returning matches");
        
    }
}
