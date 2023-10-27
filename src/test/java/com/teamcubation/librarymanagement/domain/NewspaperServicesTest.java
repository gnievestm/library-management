package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadlineException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowedException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperIsNotPossibleToReturnException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFoundException;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicatedException;
import com.teamcubation.librarymanagement.domain.managers.NewspaperManager;
import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NewspaperServicesTest {

    @Test
    void addNewEntry() throws MissingDateOrHeadlineException, NewspaperDuplicatedException {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.addNewspaper(entry), "The upload of the entry was succeeded");
    }

    @Test
    void addNewEntryWithOutHeadlineOrDate() throws MissingDateOrHeadlineException {
        Newspaper entry = new Newspaper(1, "", "");
        NewspaperManager manageEntry = new NewspaperManager();
        Exception thrown = Assertions.assertThrows(MissingDateOrHeadlineException.class, () -> {
            manageEntry.addNewspaper(entry);
        });
    }

    @Test
    void addNewEntryDuplicated() throws MissingDateOrHeadlineException, NewspaperDuplicatedException {

        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        Exception thrown = Assertions.assertThrows(NewspaperDuplicatedException.class, () -> {
            manageEntry.addNewspaper(entry);
        });

    }

    @Test
    void viewNewspaper() throws MissingDateOrHeadlineException, NewspaperDuplicatedException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        List<Newspaper> testContent = new ArrayList<>();
        testContent.add(entry);

    }

    @Test
    void viewNewspaperExist() throws MissingDateOrHeadlineException, NewspaperDuplicatedException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.viewNewspaperExist(entry), "The newspaper exists");
    }

    @Test
    void searchForNewspaperHeadline() throws MissingDateOrHeadlineException, NewspaperNotFoundException, NewspaperDuplicatedException {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        assertTrue(manageEntry.searchForNewspaperHeadline("The last stand"), "Found the newspaper with the headline");
    }

    @Test
    void searchForNewspaperHeadlineException() throws MissingDateOrHeadlineException, NewspaperNotFoundException, NewspaperDuplicatedException {
        Newspaper entry = new Newspaper(1, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.addNewspaper(entry);
        Exception thrown = assertThrows(NewspaperNotFoundException.class, () -> {
            manageEntry.searchForNewspaperHeadline("He´s back");
        });

    }

    @Test
    void borrowNewspaper() throws NewspaperAlreadyBorrowedException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        assertTrue(manageEntry.borrowNewspaper(entry), "The Newspaper is successfully borrowed");
    }

    @Test
    void borrowNewspaperException() throws NewspaperAlreadyBorrowedException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        Exception thrown = assertThrows(NewspaperAlreadyBorrowedException.class, () -> {
            manageEntry.borrowNewspaper(entry);
        });
    }

    @Test
    void returnBorrowNewspaper() throws NewspaperAlreadyBorrowedException, NewspaperIsNotPossibleToReturnException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        assertTrue(manageEntry.returnBorrowNewspaper(entry), "The newspaper was successfully returned");
    }

    @Test
    void returnBorrowNewspaperException() throws NewspaperAlreadyBorrowedException, NewspaperIsNotPossibleToReturnException {
        Newspaper entry = new Newspaper(1, "He´s Back!", "2000-07-23");
        Newspaper entry2 = new Newspaper(2, "The last stand", "2008-02-03");
        NewspaperManager manageEntry = new NewspaperManager();
        manageEntry.borrowNewspaper(entry);
        Exception thrown = assertThrows(NewspaperIsNotPossibleToReturnException.class, () -> {
            manageEntry.returnBorrowNewspaper(entry2);
        });
    }
}
