package com.todoreminder.todoremindernotificationapi.service.impl;

import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;
import com.todoreminder.todoremindernotificationapi.dto.response.TodoDto;
import com.todoreminder.todoremindernotificationapi.exception.ServiceException;
import com.todoreminder.todoremindernotificationapi.exception.UserError;
import com.todoreminder.todoremindernotificationapi.model.Notification;
import com.todoreminder.todoremindernotificationapi.model.Todo;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.repository.UserRepository;
import com.todoreminder.todoremindernotificationapi.service.NotificationService;
import com.todoreminder.todoremindernotificationapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final NotificationService notificationService;
    private final UserRepository userRepository;

    @Override
    public TodoDto create(TodoCreateDto todo) {
        User user = userRepository.findById(todo.getUsername())
                .orElseThrow(() -> new ServiceException(UserError.NOT_FOUND));
        Set<Todo> todos = user.getTodos();
        Todo newTodo = todo.toModel();
        todos.add(newTodo);
        Set<Notification> newNotifications = notificationService.notify(newTodo, user);
        Set<Notification> notifications = newTodo.getNotifications();
        if (notifications == null) {
            newTodo.setNotifications(newNotifications);
        } else {
            notifications.addAll(newNotifications);
        }
        userRepository.save(user);
        return newTodo.toDto();
    }
}
