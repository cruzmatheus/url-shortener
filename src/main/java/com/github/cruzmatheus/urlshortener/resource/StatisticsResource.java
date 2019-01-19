package com.github.cruzmatheus.urlshortener.resource;

import com.github.cruzmatheus.urlshortener.core.entity.StatisticsEntity;
import com.github.cruzmatheus.urlshortener.core.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsResource {

    @Autowired
    private StatisticsService service;

    @GetMapping("/statistics")
    public List<StatisticsEntity> getStatistics() {
        return service.retrieveStatistics();
    }
}
