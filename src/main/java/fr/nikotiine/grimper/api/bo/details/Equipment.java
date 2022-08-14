package fr.nikotiine.grimper.api.bo.details;

public class Equipment {
    private int idEquipment;
    private String libelle;

    public Equipment() {
    }

    public Equipment(int idEquipment, String libelle) {
        this();
        this.idEquipment = idEquipment;
        this.libelle = libelle;
    }

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
