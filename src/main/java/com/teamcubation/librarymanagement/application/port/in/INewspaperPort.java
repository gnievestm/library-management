package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Newspaper;

import java.util.List;

public interface INewspaperPort {

    public List<Newspaper> viewNewspaper();
}
