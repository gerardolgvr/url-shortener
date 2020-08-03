package dev.gerardo.shortener.dto;

public class AliasResponse {
    private String alias;

    public AliasResponse() { }

    public AliasResponse(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
