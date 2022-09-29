package com.todoreminder.todoremindernotificationapi.service.impl;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import com.todoreminder.todoremindernotificationapi.exception.ServiceException;
import com.todoreminder.todoremindernotificationapi.exception.UserError;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.repository.UserRepository;
import com.todoreminder.todoremindernotificationapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto findById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ServiceException(UserError.NOT_FOUND));
        return user.toDto();
    }

    @Override
    public UserDto create(User user) {
        boolean isUsernameExists = userRepository.existsById(user.getUsername());
        if (isUsernameExists) {
            throw new ServiceException(UserError.USERNAME_ALREADY_EXISTS);
        }
        userRepository.save(user);
        return user.toDto();
    }
}
