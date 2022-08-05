package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.dal.DaoFactory;
import fr.nikotiine.grimper.api.dal.LoginDao;

public class LoginController {
private LoginDao loginDao = DaoFactory.loginDao();
    private static LoginController instance;
    public static LoginController getInstance(){
        if(instance == null){
            return instance = new LoginController();
        }
        return instance;
    }

    private LoginController() {
    }
    public Token login(User user) throws ApiException {
    return loginDao.login(user);
    }
}
