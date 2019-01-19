package com.github.cruzmatheus.urlshortener.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "STATISTICS")
public class StatisticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "URL")
    private String url;

    @Column(name = "TIMES_ACCESSED")
    private Long timesAccessed;

    public StatisticsEntity() { }

    public StatisticsEntity(final String url, final Long timesAccessed) {
        this.url = url;
        this.timesAccessed = timesAccessed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTimesAccessed() {
        return timesAccessed;
    }

    public void setTimesAccessed(Long timesAccessed) {
        this.timesAccessed = timesAccessed;
    }

}
