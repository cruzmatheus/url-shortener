package com.github.cruzmatheus.urlshortener.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "URL")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORIGINAL_URL")
    private String originalUrl;

    @Column(name = "SHORTENED_URL")
    private String shortenedUrl;

    public UrlEntity() {}

    public UrlEntity(final String originalUrl, final String shortenedUrl) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }
}
