package com.bot.spider.repository;

import com.bot.spider.models.PunishmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PunishmentRepository extends JpaRepository<PunishmentModel, Long> {
}
