package com.todoreminder.todoremindernotificationapi.controller;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        UserDto newUser = userService.create(user);
        log.info("newUser: {}: ", newUser.toString());
        return ResponseEntity.ok(newUser);
    }
}
