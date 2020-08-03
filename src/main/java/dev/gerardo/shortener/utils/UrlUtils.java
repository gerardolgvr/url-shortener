package dev.gerardo.shortener.utils;

public class UrlUtils {

    public static boolean isValidWebsite(String url) {
        return url.matches("(http://|https://)?(www.)?(([-a-zA-Z0-9]+).){1,3}[a-zA-Z]+(\\/[a-zA-Z0-9#_!&\\?@%.,~=:-]*\\/?)*");
    }
}
