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
        return userDao.findByPk(idUser);
    }
    public void createNewUser(User newUser) throws ApiException {
        userDao.findOrCreate(newUser);
    }

    public void editProfil(User user) throws ApiException {
       int result =  userDao.update(user);
       System.out.println("controller edit "+ result);
       if(result != 1){
           throw new ApiException(CodeErrorController.UPDATE_FAIL);
       }
    }
}
