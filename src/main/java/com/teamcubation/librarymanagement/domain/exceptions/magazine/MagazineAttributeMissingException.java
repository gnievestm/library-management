package com.teamcubation.librarymanagement.domain.exceptions.magazine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MagazineAttributeMissingException extends Exception {
    public MagazineAttributeMissingException() {
        super("Your magazine attributes are void");
    }
}
