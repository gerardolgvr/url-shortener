package dev.gerardo.shortener.service;

import dev.gerardo.shortener.model.Url;
import dev.gerardo.shortener.utils.Shortener;
import dev.gerardo.shortener.utils.ShortenerFactory;
import dev.gerardo.shortener.utils.UrlUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlServiceTest {

    @Test
    public void saveUrlAndAlias(){
        Map<String, String> urls;
        UrlService urlService = new UrlService();
        String url = "http://nearsoft.com/";

        Shortener shortener = ShortenerFactory.getShortener(url);
        String alias = shortener.processUrl(url);


        urlService.save(new Url(url, alias));
        urls = urlService.findAll();


        assertEquals(true, urls.containsKey(url));
        assertEquals(1, urls.size());
    }

    @Test
    public void findAllShouldReturnAllUrls(){
        UrlService urlService = new UrlService();
        Map<String, String> urls;

        for(int i = 0; i < 5; i++) {
            String url = "http://nearsoft.com/"+i;
            Shortener shortener = ShortenerFactory.getShortener(url);
            String alias = shortener.processUrl(url);
            urlService.save(new Url(url, alias));
        }

        urls = urlService.findAll();
        assertEquals(5, urls.size());
    }
}
