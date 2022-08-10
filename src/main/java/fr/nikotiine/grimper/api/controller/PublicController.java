package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.bo.PublicUser;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.dal.DAO;
import fr.nikotiine.grimper.api.dal.DaoFactory;

import java.util.ArrayList;
import java.util.List;

public class PublicController {

    private static PublicController instance;
    private DAO<User> userDao = DaoFactory.DaoUser();
    private PublicController() {
    }
    public static PublicController getInstance(){
        if(instance==null){
            return instance = new PublicController();
        }
        return instance;
    }

    public List<PublicUser> getAllPseudoAndMail(){
       List<User> allUser = userDao.findAll();
       PublicUser infoUser = null;
       List<PublicUser> listOfPseudoAndMail = new ArrayList<>();
        for (User u:allUser
             ) {
            infoUser = new PublicUser(u.getNickName(), u.getEmail());
            listOfPseudoAndMail.add(infoUser);
        }
        return listOfPseudoAndMail;
    }
}
