package fr.nikotiine.grimper.api.bo;

public class ClimbingSpot {
    private int idClimbingSpot;
    private String name;
    private int averageHeight;
    private String equipment;

    public ClimbingSpot() {
    }

    public ClimbingSpot(String name, int averageHeight, String equipment) {
        this();
        this.name = name;
        this.averageHeight = averageHeight;
        this.equipment = equipment;
    }

    public ClimbingSpot(int idClimbingSpot, String name, int averageHeight, String equipment) {
        this(name,averageHeight,equipment);
        this.idClimbingSpot = idClimbingSpot;

    }

    public int getIdClimbingSpot() {
        return idClimbingSpot;
    }

    public void setIdClimbingSpot(int idClimbingSpot) {
        this.idClimbingSpot = idClimbingSpot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(int averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
