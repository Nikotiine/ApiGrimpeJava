package fr.nikotiine.grimper.api.bo;

import fr.nikotiine.grimper.api.bo.details.*;

import java.util.List;

public class ClimbingSpot {
  private int idSpot;
  private String name;
  private int idMinimumLevel;
  private int idMaximumLevel;
  private int approachTime;
  private int idApproachType;
  private int idEquipment;
  private int idEquimentQuality;
  private int idDirection;
  private int idRockType;
  private int idRoutProfil;
  private int idAverageRout;
  private int averageHeight;
  private int nbSecteur;
  private Double latitudeP1;
  private Double longitudeP1;
  private Double latitudeP2=null;
  private Double longitudeP2=null;
  private boolean reseau4g;
  private boolean water;
  private boolean toilette;
  private boolean river;
  private List<ClimbingSpotSecteur> secteurs;
  private Level minimumLevel;
  private Level maximumLevel;
  private ApprochType approchType;
  private Direction direction;
  private Equipment equipment;
  private EquipmentQuality equipmentQuality;
  private RockType rockType;
  private RoutProfil routProfil;
  private AverageRoutNumber averageRoutNumber;

  public ClimbingSpot() {
  }

  public ClimbingSpot(String name, int idMinimumLevel, int idMaximumLevel, int approachTime, int idApproachType, int idEquipment, int idEquimentQuality, int idDirection, int idRockType, int idRoutProfil, int idAverageRout,int averageHeight, int nbSecteur, Double latitudeP1, Double longitudeP1,Double latitudeP2, Double longitudeP2, boolean reseau4g, boolean water, boolean toilette, boolean river, List<ClimbingSpotSecteur> secteurs) {
    this();
    this.name = name;
    this.idMinimumLevel = idMinimumLevel;
    this.idMaximumLevel = idMaximumLevel;
    this.approachTime = approachTime;
    this.idApproachType = idApproachType;
    this.idEquipment = idEquipment;
    this.idEquimentQuality = idEquimentQuality;
    this.idDirection = idDirection;
    this.idRockType = idRockType;
    this.idRoutProfil = idRoutProfil;
    this.idAverageRout = idAverageRout;
    this.averageHeight =averageHeight;
    this.nbSecteur = nbSecteur;
    this.latitudeP1 = latitudeP1;
    this.longitudeP1 = longitudeP1;
    this.latitudeP2 = latitudeP2;
    this.longitudeP2 = longitudeP2;
    this.reseau4g = reseau4g;
    this.water = water;
    this.toilette = toilette;
    this.river = river;
    this.secteurs = secteurs;
  }

 /* public ClimbingSpot(int idSpot, String name, int approachTime,int averageHeight, int nbSecteur, Double latitudeP1, Double longitudeP1, Double latitudeP2, Double longitudeP2, boolean reseau4g, boolean water, boolean toilette, boolean river, Level minimumLevel, Level maximumLevel, ApprochType approchType, Direction direction, Equipment equipment, EquipmentQuality equipmentQuality, RockType rockType, RoutProfil routProfil , AverageRoutNumber averageRoutNumber) {
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
    this.averageRoutNumber =averageRoutNumber;
  }*/

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

  public int getIdMinimumLevel() {
    return idMinimumLevel;
  }

  public void setIdMinimumLevel(int idMinimumLevel) {
    this.idMinimumLevel = idMinimumLevel;
  }

  public int getIdMaximumLevel() {
    return idMaximumLevel;
  }

  public void setIdMaximumLevel(int idMaximumLevel) {
    this.idMaximumLevel = idMaximumLevel;
  }

  public int getApproachTime() {
    return approachTime;
  }

  public void setApproachTime(int approachTime) {
    this.approachTime = approachTime;
  }

  public int getIdApproachType() {
    return idApproachType;
  }

  public void setIdApproachType(int idApproachType) {
    this.idApproachType = idApproachType;
  }

  public int getIdEquipment() {
    return idEquipment;
  }

  public void setIdEquipment(int idEquipment) {
    this.idEquipment = idEquipment;
  }

  public int getIdEquimentQuality() {
    return idEquimentQuality;
  }

  public void setIdEquimentQuality(int idEquimentQuality) {
    this.idEquimentQuality = idEquimentQuality;
  }

  public int getIdDirection() {
    return idDirection;
  }

  public void setIdDirection(int idDirection) {
    this.idDirection = idDirection;
  }

  public int getIdRockType() {
    return idRockType;
  }

  public void setIdRockType(int idRockType) {
    this.idRockType = idRockType;
  }

  public int getIdRoutProfil() {
    return idRoutProfil;
  }

  public void setIdRoutProfil(int idRoutProfil) {
    this.idRoutProfil = idRoutProfil;
  }

  public int getIdAverageRout() {
    return idAverageRout;
  }

  public void setIdAverageRout(int idAverageRout) {
    this.idAverageRout = idAverageRout;
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

  public List<ClimbingSpotSecteur> getSecteurs() {
    return secteurs;
  }

  public void setSecteurs(List<ClimbingSpotSecteur> secteurs) {
    this.secteurs = secteurs;
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

  public int getAverageHeight() {
    return averageHeight;
  }

  public void setAverageHeight(int averageHeight) {
    this.averageHeight = averageHeight;
  }

  public AverageRoutNumber getAverageRoutNumber() {
    return averageRoutNumber;
  }

  public void setAverageRoutNumber(AverageRoutNumber averageRoutNumber) {
    this.averageRoutNumber = averageRoutNumber;
  }
}
