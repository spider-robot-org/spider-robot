package com.bot.spider.repository;

import com.bot.spider.models.AnnouncementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementModel, Long> {
}
