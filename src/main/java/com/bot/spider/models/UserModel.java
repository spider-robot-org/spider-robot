package com.bot.spider.models;

import com.bot.spider.enums.Role;
import com.bot.spider.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends GenericModel {
    private String username;

    private Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private UserStatus status;

    @Column(name = "accepted_terms_of_use")
    private boolean acceptedTermsOfUse = false;

    @Column(name = "accepted_privacy_policy")
    private boolean acceptedPrivacyPolicy = false;
}
