package dev.gerardo.shortener.utils;

import java.util.Random;

public class YahooShortener implements Shortener {

    @Override
    public String processUrl(String url) {
        Random rd = new Random();
        int cont = 0;
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        String shortenedtUrl = "";

        while(cont < 7) {
            char letter = validCharacters.charAt(rd.nextInt(validCharacters.length()));
            shortenedtUrl += String.valueOf(letter);
            cont ++;
        }

        return shortenedtUrl;
    }

}
