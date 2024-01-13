package com.bot.spider.models;

import com.bot.spider.enums.Role;
import com.bot.spider.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
public class User extends GenericModel {
    @Column()
    private String username;

    @Column()
    private Role role;

    @Column()
    private UserStatus status;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public User(Long id, String username, Role role, UserStatus status, String firstName, String lastName) {
        super(id);
        this.username = username;
        this.role = role;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id, String username, Role role, UserStatus status, String firstName) {
        super(id);
        this.username = username;
        this.role = role;
        this.status = status;
        this.firstName = firstName;
    }
}
