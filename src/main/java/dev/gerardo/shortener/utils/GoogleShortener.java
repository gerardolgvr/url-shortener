package dev.gerardo.shortener.utils;

import dev.gerardo.shortener.controllers.ShortenerController;

import java.util.Random;

public class GoogleShortener implements Shortener {

    @Override
    public String processUrl(String url) {
        Random rd = new Random();
        int cont = 0;
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        String shortenedtUrl = "";

        while(cont < 5) {
            char letter = validCharacters.charAt(rd.nextInt(validCharacters.length()));
            shortenedtUrl += String.valueOf(letter);
            cont ++;
        }

        return shortenedtUrl;
    }

}
