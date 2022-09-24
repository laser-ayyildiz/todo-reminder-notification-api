package com.todoreminder.todoremindernotificationapi.service;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import com.todoreminder.todoremindernotificationapi.model.User;

public interface UserService {

    UserDto findById(String id);

    UserDto create(User user);
}
