package dev.gerardo.shortener.controllers;

import dev.gerardo.shortener.model.Url;
import dev.gerardo.shortener.service.UrlService;
import dev.gerardo.shortener.utils.Shortener;
import dev.gerardo.shortener.utils.ShortenerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class ShortenerController {

    private UrlService urlService;

    @Autowired
    public ShortenerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/urls")
    public ResponseEntity<Map<String, String>> getUrl(){
        return new ResponseEntity<>(this.urlService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<String> getUrlByShortenedUrl(@PathVariable(value =  "shortenedUrl") String shortenedUrl) {
        Map<String, String> urls = this.urlService.findAll();

        if(urls.containsValue(shortenedUrl)) {
            String fullUrl = "";
            Set<String> setOfUrls = urls.keySet();

            for(String key : setOfUrls) {
                if(shortenedUrl.equals(urls.get(key))){
                    fullUrl = key;
                    break;
                }
            }
            return new ResponseEntity<>(fullUrl, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/urls")
    public ResponseEntity<String> shortUrl(@RequestBody Url url){
        Map<String, String> urls = urlService.findAll();

        if(url.getUrl().matches("^(http://|https://)?(www.)?([a-zA-Z0-9]+.){2}[a-z]+(\\/[a-zA-Z0-9#_!@.,=:-]+\\/?)*$")){
            if(urls.containsKey(url.getUrl())) {
                return new ResponseEntity<>(urls.get(url.getUrl()), HttpStatus.FOUND);
            } else {
                boolean isNotValidAlias = true;
                String alias = "";
                Shortener shortener = ShortenerFactory.getShortener(url.getUrl());

                while(isNotValidAlias) {
                    alias = shortener.processUrl(url.getUrl());
                    boolean isAliasAvailable = !urls.containsValue(alias);

                    if(isAliasAvailable)
                        isNotValidAlias = false;
                }

                urlService.save(url, alias);
                return new ResponseEntity<>(alias, HttpStatus.CREATED);
            }

        } else {
            return new ResponseEntity<>("Not a valid url", HttpStatus.BAD_REQUEST);
        }

    }

}
