package fr.nikotiine.grimper.api.bo.utils;

public class ResponseJson {
    private String data = "";

    public ResponseJson(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
