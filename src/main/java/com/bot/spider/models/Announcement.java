package com.bot.spider.models;

import com.bot.spider.enums.CatalogStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class Announcement extends GenericModel {
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_service_id")
    private Catalog service;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "payment_value")
    private BigDecimal paymentValue;

    @Column()
    private CatalogStatus status;

    public Announcement(Long id, User user, Catalog service, String messageId, BigDecimal paymentValue) {
        super(id);
        this.user = user;
        this.service = service;
        this.messageId = messageId;
        this.paymentValue = paymentValue;
    }

    public Announcement() {
    }
}
