package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class MissingDateOrHeadline extends Exception {
    public MissingDateOrHeadline() {
        super("You can´t register a Newspaper without a date or headline");
    }
}
