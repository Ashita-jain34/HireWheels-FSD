package com.upgrad.hirewheels.exceptions;

public class VehicleNumberNotUniqueException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public VehicleNumberNotUniqueException(String exception) {
        super(exception);
    }
}
