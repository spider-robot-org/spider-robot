package com.bot.spider.models;

import com.bot.spider.enums.ActivationType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
public class Catalog extends GenericModel {
    @Column()
    private String name;

    @Column(name = "monthly_fee")
    private BigDecimal monthlyFee;

    @ElementCollection(targetClass = String.class)
    @Enumerated(EnumType.STRING)
    private List<ActivationType> accessAllowed;

    public Catalog(Long id, String name, BigDecimal monthlyFee, List<ActivationType> accessAllowed) {
        super(id);
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.accessAllowed = accessAllowed;
    }

    public Catalog() {
    }
}
