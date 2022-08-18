package fr.nikotiine.grimper.api.bo.utils;

public class ResponseJson {
    private String data = "";
    private int id=0;

    public ResponseJson(String data) {
        this.data = data;
    }

    public ResponseJson(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
