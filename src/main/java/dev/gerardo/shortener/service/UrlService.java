package dev.gerardo.shortener.service;

import dev.gerardo.shortener.dto.UrlRequest;
import dev.gerardo.shortener.model.Url;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UrlService {

    private Map<String, String> urls;

    public UrlService() {
        urls = new Hashtable<>();
    }

    public Url save(Url url) {
        urls.put(url.getUrl(), url.getAlias());
        return url;
    }

    public Map<String, String> findAll() {
        return urls;
    }

}
