package com.todoreminder.todoremindernotificationapi.service.impl;

import com.todoreminder.todoremindernotificationapi.model.Notification;
import com.todoreminder.todoremindernotificationapi.model.NotificationPlatform;
import com.todoreminder.todoremindernotificationapi.model.Todo;
import com.todoreminder.todoremindernotificationapi.model.User;
import com.todoreminder.todoremindernotificationapi.notification.DiscordNotifier;
import com.todoreminder.todoremindernotificationapi.notification.Notifier;
import com.todoreminder.todoremindernotificationapi.notification.SlackNotifier;
import com.todoreminder.todoremindernotificationapi.notification.TelegramNotifier;
import com.todoreminder.todoremindernotificationapi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    @Value("${slack.webhook}")
    private String slackUrl;

    @Override
    public Set<Notification> notify(Todo todo, User user) {
        Set<Notification> notifications = new HashSet<>();
        Notifier notifier;
        for (NotificationPlatform platform : user.getNotifyWith()) {
            switch (platform) {
                case SLACK -> notifier = new SlackNotifier(slackUrl, todo, user);
                case DISCORD -> notifier = new DiscordNotifier(todo, user);
                case TELEGRAM -> notifier = new TelegramNotifier(todo, user);
                default -> throw new UnsupportedOperationException();
            }
            boolean isSent = notifier.send();
            Notification notification = Notification.builder().isNotified(isSent).platform(platform).build();
            notifications.add(notification);
        }
        return notifications;
    }
}
