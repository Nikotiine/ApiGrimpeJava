package fr.nikotiine.grimper.api.bo.details;

public class RockType {
    private int idRockType;
    private String type;


    public RockType() {
    }

    public RockType(int idRockType, String type) {
        this();
        this.idRockType = idRockType;
        this.type = type;
    }

    public int getIdRockType() {
        return idRockType;
    }

    public void setIdRockType(int idRockType) {
        this.idRockType = idRockType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
