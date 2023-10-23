package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewspaperManager {

    private List<Newspaper> catalogue;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline {

        if (Objects.equals(newEntry.getDate(), "") || Objects.equals(newEntry.getHeadline(), "")){
            throw new MissingDateOrHeadline();
        }
        catalogue.add(newEntry);
        return true;
    }


}
