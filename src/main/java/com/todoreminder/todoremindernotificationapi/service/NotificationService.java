package com.todoreminder.todoremindernotificationapi.service;

import com.todoreminder.todoremindernotificationapi.model.Notification;
import com.todoreminder.todoremindernotificationapi.model.Todo;
import com.todoreminder.todoremindernotificationapi.model.User;

import java.util.Set;

public interface NotificationService {

    Set<Notification> notify(Todo todo, User user);
}
