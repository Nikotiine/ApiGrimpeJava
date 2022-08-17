package fr.nikotiine.grimper.api.bo;

public class ClimbingSpotSecteur {
    private int idSecteur;
    private String name;
    private int idSpot;

    public ClimbingSpotSecteur() {
    }

    public ClimbingSpotSecteur(int idSecteur, String name) {
        this();
        this.idSecteur = idSecteur;
        this.name = name;
    }

    public ClimbingSpotSecteur(int idSecteur, String name, int idSpot) {
        this(idSecteur,name);
        this.idSpot = idSpot;
    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdSpot() {
        return idSpot;
    }

    public void setIdSpot(int idSpot) {
        this.idSpot = idSpot;
    }
}
