package com.bot.spider.models;

import com.bot.spider.enums.ActivationType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "catalog")
@AllArgsConstructor
@NoArgsConstructor
public class CatalogModel extends GenericModel {
    private String name;

    @Column(name = "subscription_price")
    private BigDecimal subscriptionPrice;

    @Column(name = "max_slot")
    private Integer maxSlot;

    @ElementCollection(targetClass = String.class)
    @Enumerated(EnumType.STRING)
    private List<ActivationType> accessAllowed;
}
