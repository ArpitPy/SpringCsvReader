package com.arpitpandey.My.Sandbox.exception;

public class CsvException extends RuntimeException {

    public CsvException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsvException(String message) {
        super(message);
    }
}
