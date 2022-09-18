package com.todoreminder.todoremindernotificationapi.service.impl;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto create(User user) {
        return user.toDto();
    }
}
