package com.todoreminder.todoremindernotificationapi.dto.request;

import lombok.*;

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

    public String toSlackMessage() {
        return "*Hey!* Do you remember this *TODO*: :ghost:" + '\n' +
                "*Do it!*: " + body + '\n' +
                "   *Where?* " + '\n' +
                "     *Project*: " + project + '\n' +
                "     *File*: " + filePath + '\n' +
                "     *Line*: " + line + '\n' +
                "     <https://github.com/" + username + "/" + project + "/blob/main/" + filePath + "#L" + line + "|:technologist:Show me in GitHub>";
    }
}
