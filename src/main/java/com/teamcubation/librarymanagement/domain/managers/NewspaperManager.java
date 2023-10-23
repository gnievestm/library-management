package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperNotFound;

import java.util.ArrayList;
import java.util.List;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<Newspaper> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
        inUse = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) {
        if (newEntry.getDate().equals("") || newEntry.getHeadline().equals("")) {
            return false;
        }
        catalogue.add(newEntry);
        return true;
    }

    public void viewNewspaper() {
        System.out.println(catalogue);
    }

    public boolean viewNewspaperRequest(Newspaper entry) {

        return catalogue.contains(entry);
    }

    public boolean borrowNewspaper(Newspaper newspaper) throws NewspaperAlreadyBorrowed {

        if (inUse.contains(newspaper)) {
            return true; //Returning the success of the exception
        } else {
            inUse.add(newspaper);
        }
        return true;
    }



}
