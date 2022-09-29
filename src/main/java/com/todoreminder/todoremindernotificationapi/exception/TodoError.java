package com.todoreminder.todoremindernotificationapi.exception;

import org.springframework.http.HttpStatus;

public enum TodoError implements Error {

    FALSE_CREDENTIALS("Please control your entries!", HttpStatus.BAD_REQUEST);
    private final String message;

    private final HttpStatus httpStatus;

    TodoError(String message, HttpStatus httpStatus) {
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
