package com.todoreminder.todoremindernotificationapi.notification;

public interface Notifier {

    boolean send();

    String generateText();
}
