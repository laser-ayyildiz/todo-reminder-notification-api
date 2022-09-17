package com.todoreminder.todoremindernotificationapi.service;

import com.todoreminder.todoremindernotificationapi.model.Todo;

public interface TodoService {

    boolean create(Todo todo, String username);
}
