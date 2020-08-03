package dev.gerardo.shortener.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlUtilsTest {

    @Test
    public void shouldValidateWebsitesUrls() {
        assertEquals(true, UrlUtils.isValidWebsite("https://www.google.com/maps/place/Amazon/@37.7913291,-122.3951599,17z/data=!4m5!3m4!1s0x808580651c518a43:0xd7a864af82c0dcb6!8m2!3d37.7913249!4d-122.3929712"));
        assertEquals(false, UrlUtils.isValidWebsite("THIS IS NOT A WEBSITE"));
        assertEquals(false, UrlUtils.isValidWebsite("this is not a website"));
        assertEquals(false, UrlUtils.isValidWebsite("hola  mundo"));
        assertEquals(true, UrlUtils.isValidWebsite("https://testing.bredex.de/naming-conventions-for-test-cases.html#:~:text=The%20easiest%20rule%20of%20thumb,on%20the%20screen%20any%20more!"));
        assertEquals(true, UrlUtils.isValidWebsite("https://es.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAAL10a3FRmdeEesBBt1xixF_lCrQyTHktPhn31JAAbDulo9x0CoTpGOjC96WNuVyDoWfZkWkuetGkkm49tseckFQ6leZot6SNh-H2EE7HMSoSmRsTN4X0NGcvP9wCVPyTMv68YWzoioBNJhElanPl1djkh76c_kcJRQsV0PVjNeGA"));
        assertEquals(true, UrlUtils.isValidWebsite("https://nearsoft.com/"));
        assertEquals(true, UrlUtils.isValidWebsite("http://nearsoft.com/"));
        assertEquals(true, UrlUtils.isValidWebsite("www.nearsoft.com/"));
        assertEquals(true, UrlUtils.isValidWebsite("www.nearsoft.com"));
        assertEquals(true, UrlUtils.isValidWebsite("nearsoft.com"));
        assertEquals(true, UrlUtils.isValidWebsite("https://es-us.vida-estilo.yahoo.com/tagged/cine/"));
    }

}
