package com.todoreminder.todoremindernotificationapi.notification;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import com.todoreminder.todoremindernotificationapi.model.Todo;
import com.todoreminder.todoremindernotificationapi.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class SlackNotifier implements Notifier {

    @Value("${slack.webhook}")
    private final String slackUrl;

    private final Todo todo;

    private final User user;

    @Override
    public boolean send() {

        Payload payload = Payload.builder().text(generateText()).build();
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

    @Override
    public String generateText() {
        return "*Hey!* Do you remember this *TODO*: :ghost:" + '\n' +
                "*Do it!*: " + todo.getBody() + '\n' +
                "   *Where?* " + '\n' +
                "     *Project*: " + todo.getProject() + '\n' +
                "     *File*: " + todo.getFilePath() + '\n' +
                "     *Line*: " + todo.getLine() + '\n' +
                "     <https://github.com/" + user.getUsername() + "/" + todo.getProject()
                + "/blob/main/" + todo.getFilePath() + "#L" + todo.getLine() + "|:technologist:Show me in GitHub>";
    }

}
