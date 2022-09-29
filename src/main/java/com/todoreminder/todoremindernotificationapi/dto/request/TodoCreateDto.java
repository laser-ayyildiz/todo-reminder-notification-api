package com.todoreminder.todoremindernotificationapi.dto.request;

import com.todoreminder.todoremindernotificationapi.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoCreateDto {

    private String body;

    private String project;

    private String filePath;

    private int line;

    private String username;

    public Todo toModel() {
        return Todo.builder().body(body).project(project).filePath(filePath).line(line).build();
    }
}
