package fr.nikotiine.grimper.api.bo.details;

public class ApprochType {
    private int idApprochType;
    private String type;

    public ApprochType() {
    }

    public ApprochType(int idApprochType, String type) {
        this();
        this.idApprochType = idApprochType;
        this.type = type;
    }

    public int getIdApprochType() {
        return idApprochType;
    }

    public void setIdApprochType(int idApprochType) {
        this.idApprochType = idApprochType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
