package com.todoreminder.todoremindernotificationapi.exception;

import org.springframework.http.HttpStatus;

public enum UserError implements Error {
    NOT_FOUND("User Not Found!", HttpStatus.NOT_FOUND),
    USERNAME_ALREADY_EXISTS("This username has ben taken." +
            "Please find another username or find the person who took and get it ( う-´)づ︻╦̵̵̿╤───", HttpStatus.CONFLICT);
    private final String message;

    private final HttpStatus httpStatus;

    UserError(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
