package fr.nikotiine.grimper.api.bo.details;

public class Level {
    private int idLevel;
    private String designation;

    public Level() {
    }

    public Level(String designation) {
        this();
        this.designation = designation;
    }

    public Level(int idLevel, String designation) {
        this(designation);
        this.idLevel = idLevel;

    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
