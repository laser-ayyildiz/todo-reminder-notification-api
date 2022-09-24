package com.todoreminder.todoremindernotificationapi.model;

import com.todoreminder.todoremindernotificationapi.dto.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.util.Date;
import java.util.Set;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class User {

    @Id
    @GeneratedValue(strategy = USE_ATTRIBUTES)
    private String id;

    @Field
    private String name;

    @Field
    private String email;

    @Field
    @IdAttribute
    private String username;

    @Field
    private String githubUsername;

    @Field
    private Set<Todo> todos;

    @Field
    private SlackCredentials slackCredentials;

    @Field
    @LastModifiedDate
    private Date lastModification;

    @Field
    @CreatedDate
    private Date creationDate;

    public UserDto toDto() {
        return UserDto.builder().name(name).email(email).username(username).build();
    }
}
