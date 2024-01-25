package com.bot.spider.models;

import com.bot.spider.enums.CatalogStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity()
@Table(name = "announcement")
public class AnnouncementModel {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "fk_service_id")
    private CatalogModel service;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "payment_value")
    private BigDecimal paymentValue;

    @Column()
    private CatalogStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public AnnouncementModel(Long id, UserModel user, CatalogModel service, String messageId, BigDecimal paymentValue) {
        this.user = user;
        this.service = service;
        this.messageId = messageId;
        this.paymentValue = paymentValue;
    }

    public AnnouncementModel() {
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
