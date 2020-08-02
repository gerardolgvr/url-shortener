package dev.gerardo.shortener.utils;

public class ShortenerFactory {

    public static Shortener getShortener(String url) {
        if(url.contains("google")){
            return new GoogleShortener();
        } else if(url.contains("yahoo")) {
            return new YahooShortener();
        } else {
            return new DefaultShortener();
        }
    }

}
