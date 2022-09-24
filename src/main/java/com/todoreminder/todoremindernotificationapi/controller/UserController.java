package com.todoreminder.todoremindernotificationapi.controller;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        UserDto newUser = userService.create(user);
        log.info("newUser: {}: ", newUser.toString());
        return ResponseEntity.ok(newUser);
    }
}
