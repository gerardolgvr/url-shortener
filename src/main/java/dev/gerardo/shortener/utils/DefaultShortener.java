package dev.gerardo.shortener.utils;

public class DefaultShortener implements Shortener {

    @Override
    public String processUrl(String url) {
        return url.replaceAll("(\\b*(https|http)\\b*)?[\\/aeiou0-9#_!@.,-=:]?", "");
    }

}
