package com.todoreminder.todoremindernotificationapi.model;

import com.todoreminder.todoremindernotificationapi.dto.response.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String body;

    private String project;

    private String filePath;

    private int line;

    private Set<Notification> notifications;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    public TodoDto toDto() {
        return TodoDto.builder().body(body).project(project).filePath(filePath).line(line).build();
    }
}
