package com.todoreminder.todoremindernotificationapi.repository;

import com.todoreminder.todoremindernotificationapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
