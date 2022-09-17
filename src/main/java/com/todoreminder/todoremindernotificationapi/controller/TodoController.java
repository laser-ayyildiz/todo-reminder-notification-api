package com.todoreminder.todoremindernotificationapi.controller;

import com.todoreminder.todoremindernotificationapi.model.Todo;
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
    public ResponseEntity<Boolean> create(@RequestBody Todo todo, @RequestParam String username) {
        boolean isSent = todoService.create(todo, username);
        return ResponseEntity.ok(isSent);
    }
}

