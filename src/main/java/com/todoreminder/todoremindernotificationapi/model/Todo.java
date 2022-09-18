package com.todoreminder.todoremindernotificationapi.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    private String body;

    private String project;

    private String filePath;

    private int line;
}
