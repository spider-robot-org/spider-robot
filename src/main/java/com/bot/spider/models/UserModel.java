package com.bot.spider.models;

import com.bot.spider.enums.Role;
import com.bot.spider.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "username can't be null")
    private String username;

    @NotNull(message = "role can't be null")
    private Role role;

    @NotBlank(message = "firstName can't be null")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "lastName can't be null")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "status can't be null")
    private UserStatus status;

    @Column(name = "accepted_terms_of_use")
    private boolean acceptedTermsOfUse = false;

    @Column(name = "accepted_privacy_policy")
    private boolean acceptedPrivacyPolicy = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UserModel(Long id, String username, Role role, String firstName, String lastName, UserStatus status, boolean acceptedTermsOfUse, boolean acceptedPrivacyPolicy) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.acceptedTermsOfUse = acceptedTermsOfUse;
        this.acceptedPrivacyPolicy = acceptedPrivacyPolicy;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}