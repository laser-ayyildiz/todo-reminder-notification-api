package com.todoreminder.todoremindernotificationapi.notification;


import com.todoreminder.todoremindernotificationapi.model.Todo;
import com.todoreminder.todoremindernotificationapi.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TelegramNotifier implements Notifier {
    private final Todo todo;

    private final User user;

    @Override
    public boolean send() {
        return true;
    }

    @Override
    public String generateText() {
        return null;
    }
}
