package com.todoreminder.todoremindernotificationapi.exception;

import org.springframework.http.HttpStatus;

public interface Error {

    HttpStatus getHttpStatus();

    String getMessage();
}
