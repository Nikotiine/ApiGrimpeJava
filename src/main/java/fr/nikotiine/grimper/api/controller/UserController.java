package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.PublicUser;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.bo.UserPassword;
import fr.nikotiine.grimper.api.dal.DAO;
import fr.nikotiine.grimper.api.dal.DaoFactory;
import fr.nikotiine.grimper.api.dal.LoginDao;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static UserController instance;
    private DAO<User> userDao = DaoFactory.DaoUser();
    private LoginDao loginDao = DaoFactory.loginDao();

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
        if (checkIfPseudoAndMailIsValide(user.getNickName(), user.getEmail(), user.getIdUser())){
            int result =  userDao.update(user);
            if(result != 1){
                throw new ApiException(CodeErrorController.UPDATE_FAIL);
            }
        }

    };

    public void changePassword(UserPassword passwords ,int idUser) throws ApiException {
       int result =  loginDao.changePassword(passwords, idUser);
        if(result != 1){
            throw new ApiException(CodeErrorController.UPDATE_FAIL);
        }
    }
    private boolean checkIfPseudoAndMailIsValide(String nickName,String email , int id ) throws ApiException {
        List<User> allUser = userDao.findAll();

        for (User u:allUser
        ) {
          if(u.getNickName().equals(nickName) && u.getIdUser()!=id){
             throw new ApiException(CodeErrorController.PSEUDO_EXISTANT);
          }
          if(u.getEmail().equals(email) && u.getIdUser()!=id){
              throw new ApiException(CodeErrorController.EMAIL_EXISTANT);
          }
        }

        return true;
    }
}

