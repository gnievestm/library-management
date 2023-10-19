package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class addNewspaperTest {

    
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

    
}
