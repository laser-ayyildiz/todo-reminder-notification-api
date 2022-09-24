package com.todoreminder.todoremindernotificationapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private List<String> errors;

    private String path;

    private LocalDateTime timestamp;

    public static ErrorResponse from(HttpServletRequest request, Error error) {
        return ErrorResponse.builder().errors(List.of(error.getMessage())).path(request.getRequestURI())
                .timestamp(LocalDateTime.now()).build();
    }
}
