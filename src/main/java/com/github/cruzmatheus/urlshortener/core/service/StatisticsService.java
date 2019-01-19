package com.github.cruzmatheus.urlshortener.core.service;

import com.github.cruzmatheus.urlshortener.core.entity.StatisticsEntity;
import com.github.cruzmatheus.urlshortener.core.repository.StatisticsRepository;
import com.github.cruzmatheus.urlshortener.core.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private UrlRepository repository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    public void countUp(final String url) {
        StatisticsEntity statistics = statisticsRepository.findByUrl(url);

        if (statistics == null) {
            statistics = new StatisticsEntity(url, 1L);
            statisticsRepository.save(statistics);
        } else {
            statistics.setTimesAccessed(statistics.getTimesAccessed() + 1);
            statisticsRepository.saveAndFlush(statistics);
        }
    }

    public List<StatisticsEntity> retrieveStatistics() {
        return statisticsRepository.findAll();
    }
}
