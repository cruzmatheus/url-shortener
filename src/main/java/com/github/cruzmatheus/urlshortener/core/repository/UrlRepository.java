package com.github.cruzmatheus.urlshortener.core.repository;

import com.github.cruzmatheus.urlshortener.core.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    UrlEntity findByShortenedUrl(String shortenedUrl);

    UrlEntity findByOriginalUrl(String originalUrl);
}
