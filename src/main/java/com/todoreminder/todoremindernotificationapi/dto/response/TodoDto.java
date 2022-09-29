package com.todoreminder.todoremindernotificationapi.dto.response;

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
public class TodoDto {

    private String body;

    private String project;

    private String filePath;

    private int line;
}
