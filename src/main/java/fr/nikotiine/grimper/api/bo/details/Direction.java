package fr.nikotiine.grimper.api.bo.details;

public class Direction {
    private int idDirections;
    private String direction;

    public Direction() {
    }

    public Direction(int idDirections, String direction) {
        this();
        this.idDirections = idDirections;
        this.direction = direction;
    }

    public int getIdDirections() {
        return idDirections;
    }

    public void setIdDirections(int idDirections) {
        this.idDirections = idDirections;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
