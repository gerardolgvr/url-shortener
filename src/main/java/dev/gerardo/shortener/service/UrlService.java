package dev.gerardo.shortener.service;

import dev.gerardo.shortener.model.Url;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UrlService {

    private Map<String, String> urls;

    public UrlService() {
        urls = new Hashtable<>();
    }

    public String save(Url url, String alias) {
        urls.put(url.getUrl(), alias);
        return alias;
    }

    public Map<String, String> findAll() {
        return urls;
    }

}
