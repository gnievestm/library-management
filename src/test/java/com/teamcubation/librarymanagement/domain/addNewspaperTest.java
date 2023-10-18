package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class addNewspaperTest {

    @Test
    void addNewEntry(){

            Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
            NewspaperManager createEntry = new NewspaperManager();
            createEntry.addNewspaper(entry);


    }
}
