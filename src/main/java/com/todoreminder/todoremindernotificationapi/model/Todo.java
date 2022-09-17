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

    public String toSlackMessage(String githubUsername) {
        return "*Hey!* Do you remember this *TODO*: :ghost:" + '\n' +
                "*Do it!*: " + body + '\n' +
                "   *Where?* " + '\n' +
                "     *Project*: " + project + '\n' +
                "     *File*: " + filePath + '\n' +
                "     *Line*: " + line + '\n' +
                "     <https://github.com/" + githubUsername + "/" + project + "/blob/main/" + filePath + "#L" + line + "|:technologist:Show me in GitHub>";
    }
}
