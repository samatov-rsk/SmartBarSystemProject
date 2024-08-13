package com.samatov.inventoryservicebar.common.exceptions.validationexceptions;


/**
 * Exception при не корректной валидации полей.
 */

public class InvalidBeerDataException extends RuntimeException {

    public InvalidBeerDataException(String message) {
        super(message);
    }
}
