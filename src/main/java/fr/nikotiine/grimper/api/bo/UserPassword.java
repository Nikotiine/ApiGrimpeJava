package fr.nikotiine.grimper.api.bo;

public class UserPassword {
    private String oldPassword = "";
    private String newPassword = "";

    public UserPassword(String oldPassword, String newPassword) {
        this();
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public UserPassword() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
