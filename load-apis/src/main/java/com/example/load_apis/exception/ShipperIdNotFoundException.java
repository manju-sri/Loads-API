package com.example.load_apis.exception;

public class ShipperIdNotFoundException extends RuntimeException {
    public ShipperIdNotFoundException(String message) {
        super(message);
    }
}
