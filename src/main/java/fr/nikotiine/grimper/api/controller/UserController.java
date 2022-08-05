package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.dal.DAO;
import fr.nikotiine.grimper.api.dal.DaoFactory;

import java.util.List;

public class UserController {
    private static UserController instance;
    private DAO<User> userDao = DaoFactory.DaoUser();

    public static UserController getInstance(){
        if(instance==null){
            return instance = new UserController();
        }
        return instance;
    }

    private UserController() {
    }
    private List<User> userCatalogue(){
        return userDao.findAll();
    }
    public User getProfil(int idUser){
      List<User> allUsers = userCatalogue();
      User user = new User();
        for (User u:allUsers
             ) {
            if(u.getIdUser()==idUser){
                user = u;
            }
        }
        return user;
    }
    public void createNewUser(User newUser) throws ApiException {
        userDao.findOrCreate(newUser);
    }
}
