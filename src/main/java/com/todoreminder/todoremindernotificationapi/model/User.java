package com.todoreminder.todoremindernotificationapi.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;

    @Email
    private String email;

    @Size(min = 3)
    private String username;

    private String githubUsername;

    private Set<Todo> todos;

    private SlackCredentials slackCredentials;
}
