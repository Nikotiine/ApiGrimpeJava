package fr.nikotiine.grimper.api.bo;

import fr.nikotiine.grimper.api.bo.details.*;

public class ClimbingSpotDto {
    int idSpot;
    String name;
    int approachTime;
    int averageHeight;
    int nbSecteur;
    Double latitudeP1;
    Double longitudeP1;
    Double latitudeP2;
    Double longitudeP2;
    boolean reseau4g;
    boolean water;
    boolean toilette;
    boolean river;
    Level minimumLevel;
    Level maximumLevel;
    ApprochType approchType;
    Direction direction;
    Equipment equipment;
    EquipmentQuality equipmentQuality;
    RockType rockType;
    RoutProfil routProfil ;
    AverageRoutNumber averageRoutNumber;

    public ClimbingSpotDto(int idSpot, String name, int approachTime, int averageHeight, int nbSecteur, Double latitudeP1, Double longitudeP1, Double latitudeP2, Double longitudeP2, boolean reseau4g, boolean water, boolean toilette, boolean river, Level minimumLevel, Level maximumLevel, ApprochType approchType, Direction direction, Equipment equipment, EquipmentQuality equipmentQuality, RockType rockType, RoutProfil routProfil, AverageRoutNumber averageRoutNumber) {
        this.idSpot = idSpot;
        this.name = name;
        this.approachTime = approachTime;
        this.averageHeight = averageHeight;
        this.nbSecteur = nbSecteur;
        this.latitudeP1 = latitudeP1;
        this.longitudeP1 = longitudeP1;
        this.latitudeP2 = latitudeP2;
        this.longitudeP2 = longitudeP2;
        this.reseau4g = reseau4g;
        this.water = water;
        this.toilette = toilette;
        this.river = river;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.approchType = approchType;
        this.direction = direction;
        this.equipment = equipment;
        this.equipmentQuality = equipmentQuality;
        this.rockType = rockType;
        this.routProfil = routProfil;
        this.averageRoutNumber = averageRoutNumber;
    }

    public int getIdSpot() {
        return idSpot;
    }

    public void setIdSpot(int idSpot) {
        this.idSpot = idSpot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApproachTime() {
        return approachTime;
    }

    public void setApproachTime(int approachTime) {
        this.approachTime = approachTime;
    }

    public int getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(int averageHeight) {
        this.averageHeight = averageHeight;
    }

    public int getNbSecteur() {
        return nbSecteur;
    }

    public void setNbSecteur(int nbSecteur) {
        this.nbSecteur = nbSecteur;
    }

    public Double getLatitudeP1() {
        return latitudeP1;
    }

    public void setLatitudeP1(Double latitudeP1) {
        this.latitudeP1 = latitudeP1;
    }

    public Double getLongitudeP1() {
        return longitudeP1;
    }

    public void setLongitudeP1(Double longitudeP1) {
        this.longitudeP1 = longitudeP1;
    }

    public Double getLatitudeP2() {
        return latitudeP2;
    }

    public void setLatitudeP2(Double latitudeP2) {
        this.latitudeP2 = latitudeP2;
    }

    public Double getLongitudeP2() {
        return longitudeP2;
    }

    public void setLongitudeP2(Double longitudeP2) {
        this.longitudeP2 = longitudeP2;
    }

    public boolean isReseau4g() {
        return reseau4g;
    }

    public void setReseau4g(boolean reseau4g) {
        this.reseau4g = reseau4g;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isToilette() {
        return toilette;
    }

    public void setToilette(boolean toilette) {
        this.toilette = toilette;
    }

    public boolean isRiver() {
        return river;
    }

    public void setRiver(boolean river) {
        this.river = river;
    }

    public Level getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(Level minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public Level getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(Level maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public ApprochType getApprochType() {
        return approchType;
    }

    public void setApprochType(ApprochType approchType) {
        this.approchType = approchType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentQuality getEquipmentQuality() {
        return equipmentQuality;
    }

    public void setEquipmentQuality(EquipmentQuality equipmentQuality) {
        this.equipmentQuality = equipmentQuality;
    }

    public RockType getRockType() {
        return rockType;
    }

    public void setRockType(RockType rockType) {
        this.rockType = rockType;
    }

    public RoutProfil getRoutProfil() {
        return routProfil;
    }

    public void setRoutProfil(RoutProfil routProfil) {
        this.routProfil = routProfil;
    }

    public AverageRoutNumber getAverageRoutNumber() {
        return averageRoutNumber;
    }

    public void setAverageRoutNumber(AverageRoutNumber averageRoutNumber) {
        this.averageRoutNumber = averageRoutNumber;
    }
}
