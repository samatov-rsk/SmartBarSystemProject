package com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions;

/**
 * Exception что определенное пиво не было найдено
 */

public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(String message) {
        super(message);
    }
}
