package com.soave.freelancerdeals.domain.exception;

import com.soave.freelancerdeals.domain.enums.ErrorMessage;

public class GenericErrorException extends Exception{

    public GenericErrorException(){
        super(ErrorMessage.GENERIC_ERROR.getMessage());
    }
}
