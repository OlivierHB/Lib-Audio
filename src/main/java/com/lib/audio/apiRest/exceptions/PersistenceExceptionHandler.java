package com.lib.audio.apiRest.exceptions;

import javax.persistence.PersistenceException;

public class PersistenceExceptionHandler extends PersistenceException {

    public PersistenceExceptionHandler(String message) {
        super(message);
    }
}
