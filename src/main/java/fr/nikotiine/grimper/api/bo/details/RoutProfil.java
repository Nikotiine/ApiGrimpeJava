package fr.nikotiine.grimper.api.bo.details;

public class RoutProfil {
    private int idRoutProfil;
    private String profil;

    public RoutProfil() {
    }

    public RoutProfil(int idRoutProfil, String profil) {
        this();
        this.idRoutProfil = idRoutProfil;
        this.profil = profil;
    }

    public int getIdRoutProfil() {
        return idRoutProfil;
    }

    public void setIdRoutProfil(int idRoutProfil) {
        this.idRoutProfil = idRoutProfil;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
