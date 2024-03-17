package com.bot.spider.models;

import com.bot.spider.enums.CatalogStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "announcement")
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementModel extends GenericModel {
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
}
