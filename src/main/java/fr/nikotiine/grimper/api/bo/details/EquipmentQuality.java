package fr.nikotiine.grimper.api.bo.details;

public class EquipmentQuality {
    private int idEquipmentQuality;
    private String quality;

    public EquipmentQuality() {
    }

    public EquipmentQuality(int idEquipmentQuality, String quality) {
        this();
        this.idEquipmentQuality = idEquipmentQuality;
        this.quality = quality;
    }

    public int getIdEquipmentQuality() {
        return idEquipmentQuality;
    }

    public void setIdEquipmentQuality(int idEquipmentQuality) {
        this.idEquipmentQuality = idEquipmentQuality;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}

