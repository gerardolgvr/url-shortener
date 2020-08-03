package dev.gerardo.shortener.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortenerTests {

    @Test
    public void shouldReturnGoogleShortenerClassName(){
        String[] urls = new String[] {
                "https://www.google.com/maps/place/Amazon/@37.7913291,-122.3951599,17z/data=!4m5!3m4!1s0x808580651c518a43:0xd7a864af82c0dcb6!8m2!3d37.7913249!4d-122.3929712",
                "https://www.google.com/search?q=jsjdf&rlz=1C1CHBF_esMX811MX811&oq=jsjdf&aqs=chrome..69i57.1288j0j7&sourceid=chrome&ie=UTF-8",
                "https://drive.google.com/"
        };

        for(int i = 0; i < urls.length; i++) {
            Shortener shortener = ShortenerFactory.getShortener(urls[i]);
            assertEquals(true, shortener.getClass().getName().contains("GoogleShortener"));
        }
    }

    @Test
    public void shouldReturnYahooShortenerClassName(){
        String[] urls = new String[] {
                "https://login.yahoo.com/",
                "https://es-us.vida-estilo.yahoo.com/tagged/cine/",
                "https://es.yahoo.com//"
        };

        for(int i = 0; i < urls.length; i++) {
            Shortener shortener = ShortenerFactory.getShortener(urls[i]);
            assertEquals(true, shortener.getClass().getName().contains("YahooShortener"));
        }
    }

    @Test
    public void shouldReturnDefaultShortenerClassName(){
        String[] urls = new String[] {
                "https://nearsoft.com/",
                "https://trello.com/es",
                "https://nowports.com//"
        };

        for(int i = 0; i < urls.length; i++) {
            Shortener shortener = ShortenerFactory.getShortener(urls[i]);
            assertEquals(true, shortener.getClass().getName().contains("DefaultShortener"));
        }
    }
}
