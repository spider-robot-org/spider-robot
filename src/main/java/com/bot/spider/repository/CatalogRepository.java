package com.bot.spider.repository;

import com.bot.spider.models.CatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogModel, Long> {
}
