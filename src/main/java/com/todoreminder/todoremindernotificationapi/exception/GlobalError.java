package com.todoreminder.todoremindernotificationapi.exception;

import org.springframework.http.HttpStatus;

public enum GlobalError implements Error {
    INTERNAL_SERVER_ERROR("We have some problem. You can contact with my creator: laserayyildiz@gmail.com",
            HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;

    private final HttpStatus httpStatus;

    GlobalError(String message, HttpStatus httpStatus) {
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
