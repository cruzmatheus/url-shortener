package com.github.cruzmatheus.urlshortener.core.service;

import com.github.cruzmatheus.urlshortener.core.entity.UrlEntity;
import com.github.cruzmatheus.urlshortener.core.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenerService {

    @Autowired
    private UrlRepository repository;

    public String doShortUrl(final String url) {
        final String shortenedUrl = "https://sho.rt/" + RandomStringUtils.random(6, true, true);
        final UrlEntity urlEntity = repository.save(new UrlEntity(url, shortenedUrl));
        return urlEntity.getShortenedUrl();
    }

    public String retrieveUrl(final String shortenedUrl) {
        final UrlEntity urlEntity = repository.findByShortenedUrl(shortenedUrl);
        return urlEntity.getOriginalUrl();
    }

}
