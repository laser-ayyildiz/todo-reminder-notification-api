package com.todoreminder.todoremindernotificationapi.service.impl;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import com.todoreminder.todoremindernotificationapi.dto.request.TodoCreateDto;
import com.todoreminder.todoremindernotificationapi.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Value("${slack.webhook}")
    private String slackUrl;

    @Override
    public boolean create(TodoCreateDto todo) {
        Payload payload = Payload.builder()
                .text(todo.toSlackMessage())
                .build();
        WebhookResponse webhookResponse;
        try {
            webhookResponse = Slack.getInstance().send(slackUrl, payload);
            log.info("Message response: {}", webhookResponse.toString());
        } catch (IOException e) {
            log.error("Unexpected error on this webhook: {}", slackUrl);
            return false;
        }

        return webhookResponse.getCode() == 200;
    }
}
