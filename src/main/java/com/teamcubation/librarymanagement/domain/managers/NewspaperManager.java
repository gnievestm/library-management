package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;

import java.util.ArrayList;
import java.util.List;

public class NewspaperManager {

    private List<Newspaper> catalogue;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
    }

    public void addNewspaper(Newspaper newEntry){
        catalogue.add(newEntry);

    }

    public boolean viewNewspaper(){
        if (catalogue.isEmpty()){
            return false;
        }
        return true;
    }

}