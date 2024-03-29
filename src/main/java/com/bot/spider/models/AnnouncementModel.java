package com.bot.spider.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bot.spider.enums.CatalogStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "announcement")
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private CatalogStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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
