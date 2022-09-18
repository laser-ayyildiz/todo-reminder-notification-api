package com.todoreminder.todoremindernotificationapi.dto.response;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {

    private String name;

    @Email
    private String email;

    @Size(min = 3)
    private String username;

}
