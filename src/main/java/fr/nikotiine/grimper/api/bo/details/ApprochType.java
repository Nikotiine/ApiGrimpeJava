package fr.nikotiine.grimper.api.bo.details;

public class ApprochType {
    private int idApprochType;
    private String type;

    public ApprochType() {
    }

    public ApprochType(String type) {
        this();
        this.type = type;
    }

    public ApprochType(int idApprochType, String type) {
        this(type);
        this.idApprochType = idApprochType;
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
