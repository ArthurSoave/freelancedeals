package com.soave.freelancerdeals.domain.enums;

public enum ErrorMessage {

    NOT_FOUND("REGISTER NOT FOUND"),
    GENERIC_ERROR("AN ERROR HAS OCCURED, CONTACT THE ADMINISTRATOR");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
