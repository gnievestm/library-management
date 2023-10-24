package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.MissingDateOrHeadline;
import com.teamcubation.librarymanagement.domain.exceptions.Newspaper.NewspaperDuplicated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewspaperManager {

    private List<Newspaper> catalogue;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
    }

    public boolean addNewspaper(Newspaper newEntry) throws MissingDateOrHeadline, NewspaperDuplicated {
        if (Objects.equals(newEntry.getDate(), "") || Objects.equals(newEntry.getHeadline(), "")){
            throw new MissingDateOrHeadline();
        } else if (catalogue.contains(newEntry)) {
            throw new NewspaperDuplicated();
        }
        catalogue.add(newEntry);
        return true;
    }


}
