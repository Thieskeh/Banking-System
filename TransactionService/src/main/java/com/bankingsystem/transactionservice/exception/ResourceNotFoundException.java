package com.bankingsystem.transactionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to be thrown when a resource is not found.
 * This exception is annotated with {@link ResponseStatus} to automatically set the HTTP status code to 404 (Not Found).
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor for the ResourceNotFoundException class.
     *
     * @param message The error message to be displayed when this exception is thrown.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
