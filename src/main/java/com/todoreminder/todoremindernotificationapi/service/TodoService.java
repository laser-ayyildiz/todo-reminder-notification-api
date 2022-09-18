package com.todoreminder.todoremindernotificationapi.service;

import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;

public interface TodoService {

    boolean create(TodoCreateDto todo);
}
