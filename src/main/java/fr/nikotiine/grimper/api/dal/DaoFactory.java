package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.bo.User;

public class DaoFactory {
    public static DAO<User> DaoUser(){return new UserImplJdbc();}
    public static LoginDao loginDao(){return new UserImplJdbc();}
}
