package com.bot.spider.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.bot.spider.enums.ActivationType;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "catalog")
@AllArgsConstructor
@NoArgsConstructor
public class CatalogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

	 @Column(name = "subscription_price")
    private BigDecimal subscriptionPrice;

	 @Column(name = "max_slot")
	 private Integer maxSlot;

    @ElementCollection(targetClass = String.class)
    @Enumerated(EnumType.STRING)
    private List<ActivationType> accessAllowed;

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
