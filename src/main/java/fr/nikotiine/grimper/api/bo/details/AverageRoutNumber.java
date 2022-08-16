package fr.nikotiine.grimper.api.bo.details;

public class AverageRoutNumber {
    private int idAverageRoutNumber;
    private String libelle;

    public AverageRoutNumber() {
    }

    public AverageRoutNumber(int idAverageRoutNumber, String libelle) {
        this();
        this.idAverageRoutNumber = idAverageRoutNumber;
        this.libelle = libelle;
    }

    public int getIdAverageRoutNumber() {
        return idAverageRoutNumber;
    }

    public void setIdAverageRoutNumber(int idAverageRoutNumber) {
        this.idAverageRoutNumber = idAverageRoutNumber;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
