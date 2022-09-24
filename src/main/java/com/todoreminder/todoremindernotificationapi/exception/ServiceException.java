package com.todoreminder.todoremindernotificationapi.exception;

public class ServiceException extends RuntimeException {

    private final Error error;

    public ServiceException(Error error) {
        super(error.getMessage());
        this.error = error;
    }


    public Error getError() {
        return error;
    }
}
