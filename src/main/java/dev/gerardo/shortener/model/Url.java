package dev.gerardo.shortener.model;

public class Url {
    private String url;

    public Url(){ }

    public Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
