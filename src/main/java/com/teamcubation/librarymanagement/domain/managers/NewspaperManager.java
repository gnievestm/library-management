package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;

import java.util.ArrayList;
import java.util.List;

public class NewspaperManager {

    private List<Newspaper> catalogue;
    private List<NewspaperManager> inUse;

    public NewspaperManager() {
        catalogue = new ArrayList<>();
        inUse = new ArrayList<>();
    }

    public void addNewspaper(Newspaper newEntry){
        catalogue.add(newEntry);
    }

    public void viewNewspaper(){
        System.out.println(catalogue);
    }
    public boolean viewNewspaperRequest(Newspaper entry){

        return catalogue.contains(entry);
    }

    public boolean borrowNewspaper(List<Newspaper> catalogue){

        if (inUse.contains((NewspaperManager) catalogue)){
            return false;
        }else {
            inUse.add((NewspaperManager) catalogue);
            return true;
        }
    }
    
    public boolean returnBorrowNewspaper(List<Newspaper> catalogue){

        if (!inUse.contains((NewspaperManager) catalogue)){
            catalogue.add((Newspaper) inUse);
            return true;
        }else {

            return false;
        }
    }
}
