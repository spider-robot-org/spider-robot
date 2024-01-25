package com.bot.spider.models;

import com.bot.spider.enums.ActivationType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity()
@Table(name = "catalog")
public class CatalogModel {
    @Id
    private Long id;

    @Column()
    private String name;

    @Column(name = "monthly_fee")
    private BigDecimal monthlyFee;

    @ElementCollection(targetClass = String.class)
    @Enumerated(EnumType.STRING)
    private List<ActivationType> accessAllowed;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CatalogModel(Long id, String name, BigDecimal monthlyFee, List<ActivationType> accessAllowed) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.accessAllowed = accessAllowed;
    }

    public CatalogModel() {
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
