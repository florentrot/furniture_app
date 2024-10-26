package com.example.restapi.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
