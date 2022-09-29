package com.todoreminder.todoremindernotificationapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    private String id;

    private DateTime notifyAt;

    private int frequency;

    private boolean isNotified;

    private NotificationPlatform platform;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;
}
