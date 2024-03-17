package com.bot.spider.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "punishment")
@AllArgsConstructor
@NoArgsConstructor
public class PunishmentModel extends GenericModel {
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private UserModel user;

    private String reason;

    @Column(name = "suspension_expiry_date")
    private LocalDateTime suspensionExpiryDate;

    @Column(name = "warning_given")
    private boolean warningGiven;
}
