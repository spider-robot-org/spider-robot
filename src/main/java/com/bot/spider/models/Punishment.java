package com.bot.spider.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
public class Punishment extends GenericModel {
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Column()
    private String reason;

    @Column(name = "suspension_expiry_date")
    private LocalDateTime suspensionExpiryDate;

    public Punishment(Long id, User user, String reason, LocalDateTime suspensionExpiryDate) {
        super(id);
        this.user = user;
        this.reason = reason;
        this.suspensionExpiryDate = suspensionExpiryDate;
    }

    public Punishment() {
    }
}
