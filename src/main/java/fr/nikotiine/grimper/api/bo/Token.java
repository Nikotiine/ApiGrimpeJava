package fr.nikotiine.grimper.api.bo;

public class Token {
    private String acces_token = "";

    public Token(String token) {
        this.acces_token = token;
    }

    public String getToken() {
        return acces_token;
    }

    public void setToken(String token) {
        this.acces_token = token;
    }
}
