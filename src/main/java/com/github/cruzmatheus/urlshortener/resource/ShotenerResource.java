package com.github.cruzmatheus.urlshortener.resource;

import com.github.cruzmatheus.urlshortener.core.service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ShotenerResource {

    @Autowired
    private ShortenerService service;
    
    @GetMapping("/doShort")
    public String doShort(@RequestParam final String url) {
        return service.doShortUrl(url);
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void redirectToUrl(@RequestParam String shortenedUrl, HttpServletResponse resp) throws Exception {
        final String url = service.retrieveUrl(shortenedUrl);
        resp.addHeader("Location", url);
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    }


}
