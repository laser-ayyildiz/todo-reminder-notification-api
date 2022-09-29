package com.todoreminder.todoremindernotificationapi.service;

import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;
import com.todoreminder.todoremindernotificationapi.dto.response.TodoDto;

public interface TodoService {

    TodoDto create(TodoCreateDto todo);
}
