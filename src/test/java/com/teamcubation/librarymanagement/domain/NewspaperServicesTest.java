package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NewspaperServicesTest {

    @Test
    void addNewEntry(){

            Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
            NewspaperManager manageEntry = new NewspaperManager();
            manageEntry.addNewspaper(entry);


    }

    @Test
    void viewNewspaper(){

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        manageEntry.viewNewspaper();

    }
    @Test
    void viewNewspaperRequest(){

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);

        manageEntry.viewNewspaperRequest(entry);

    }
}
