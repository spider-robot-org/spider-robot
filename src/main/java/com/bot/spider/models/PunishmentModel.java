package com.bot.spider.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity()
@Table(name = "punishment")
public class PunishmentModel {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private UserModel user;

    private String reason;

    @Column(name = "suspension_expiry_date")
    private LocalDateTime suspensionExpiryDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public PunishmentModel(Long id, UserModel user, String reason, LocalDateTime suspensionExpiryDate) {
        this.user = user;
        this.reason = reason;
        this.suspensionExpiryDate = suspensionExpiryDate;
    }

    public PunishmentModel() {
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
