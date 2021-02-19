package com.soave.freelancerdeals.domain.exception;

import com.soave.freelancerdeals.domain.enums.ErrorMessage;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(ErrorMessage.NOT_FOUND.getMessage());
    }
}
