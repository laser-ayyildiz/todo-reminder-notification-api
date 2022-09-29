package com.todoreminder.todoremindernotificationapi.controller;

import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;
import com.todoreminder.todoremindernotificationapi.dto.response.TodoDto;
import com.todoreminder.todoremindernotificationapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoCreateDto todo) {
        TodoDto newTodo = todoService.create(todo);
        return ResponseEntity.ok(newTodo);
    }
}

