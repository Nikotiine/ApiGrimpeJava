package fr.nikotiine.grimper.api.bo;

import java.io.Serializable;
import java.sql.Date;



public class User implements Serializable {

    private int idUser;
    private String nickName;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Date birthday;
    private char sex;
    private boolean admin;

    public User() {
    }

    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public User(String nickName, String lastName, String firstName, String email, String password, Date birthday, char sex) {
        this(nickName,password);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email=email;
        this.birthday = birthday;
        this.sex = sex;
    }

    public User(int idUser, String nickName, String lastName, String firstName ,String email,String password, Date birthday, char sex, boolean admin) {
        this(nickName,lastName,firstName,email,password,birthday,sex);
        this.idUser = idUser;
        this.admin = admin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
