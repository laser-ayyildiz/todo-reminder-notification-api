package com.todoreminder.todoremindernotificationapi.controller;

import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;
import com.todoreminder.todoremindernotificationapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody TodoCreateDto todo) {
        boolean isSent = todoService.create(todo);
        return ResponseEntity.ok(isSent);
    }
}

