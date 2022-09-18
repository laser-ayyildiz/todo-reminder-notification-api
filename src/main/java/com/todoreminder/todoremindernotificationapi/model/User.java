package com.todoreminder.todoremindernotificationapi.model;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
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

    public UserDto toDto() {
        return UserDto.builder().name(name).email(email).username(username).build();
    }
}
