package com.github.cruzmatheus.urlshortener.core.repository;

import com.github.cruzmatheus.urlshortener.core.entity.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {

    StatisticsEntity findByUrl(String url);
}
