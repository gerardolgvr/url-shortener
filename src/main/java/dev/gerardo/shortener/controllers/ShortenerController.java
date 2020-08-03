package dev.gerardo.shortener.controllers;

import dev.gerardo.shortener.dto.AliasResponse;
import dev.gerardo.shortener.dto.UrlRequest;
import dev.gerardo.shortener.model.Url;
import dev.gerardo.shortener.service.UrlService;
import dev.gerardo.shortener.utils.Shortener;
import dev.gerardo.shortener.utils.ShortenerFactory;
import dev.gerardo.shortener.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@RestController
public class ShortenerController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/urls")
    @ResponseBody
    public Map<String, String> getUrls(){
        return this.urlService.findAll();
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
    public ResponseEntity<?> shortUrl(@Valid @RequestBody UrlRequest urlRequest){
        Map<String, String> urls = urlService.findAll();

        if(UrlUtils.isValidWebsite(urlRequest.getUrl())){
            if(urls.containsKey(urlRequest.getUrl())) {
                return new ResponseEntity<>(new AliasResponse(urls.get(urlRequest.getUrl())), HttpStatus.CREATED);
            } else {
                boolean isNotValidAlias = true;
                String alias = "";
                Shortener shortener = ShortenerFactory.getShortener(urlRequest.getUrl());

                while(isNotValidAlias) {
                    alias = shortener.processUrl(urlRequest.getUrl());
                    boolean isAliasAvailable = !urls.containsValue(alias);

                    if(isAliasAvailable)
                        isNotValidAlias = false;
                }

                Url url = new Url(urlRequest.getUrl(), alias);

                urlService.save(url);
                return new ResponseEntity<>(new AliasResponse(alias), HttpStatus.CREATED);
            }

        } else {
            return new ResponseEntity<>("Not a valid url", HttpStatus.BAD_REQUEST);
        }

    }

}
