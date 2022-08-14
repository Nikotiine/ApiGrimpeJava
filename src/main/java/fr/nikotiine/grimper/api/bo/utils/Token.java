package fr.nikotiine.grimper.api.bo.utils;

public class Token {
    private String acces_token = "";
    private int idUser;


    public Token(String token , int idUser) {

        this.acces_token = token;
        this.idUser = idUser;
    }



    public String getAcces_token() {
        return acces_token;
    }

    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
