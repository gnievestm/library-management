package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;

import java.util.ArrayList;
import java.util.List;

public class NewspaperManager {

    private List<Newspaper> catalogue;

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline {
        try {
            if (newEntry.getDate().isEmpty() || newEntry.getHeadline().equals("")) {
                throw new MissingDateOrHeadline();
            } else {
                catalogue.add(newEntry);
            }
        } catch (MissingDateOrHeadline e) {

        }
        return true;
    }



}
