package fr.nikotiine.grimper.api.service;

import fr.nikotiine.grimper.api.bo.details.AllDetailList;
import fr.nikotiine.grimper.api.bo.details.ApprochType;
import fr.nikotiine.grimper.api.bo.details.Level;
import fr.nikotiine.grimper.api.controller.ClimbingSpotController;
import fr.nikotiine.grimper.api.dal.DaoFactory;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.util.List;

public class DetailService {
    private static DetailService instance;
    public static DetailService getInstance(){
        if(instance == null){
            return instance = new DetailService();
        }
        return instance;
    }

    public DetailService() {
    }

    private DetailDao approchTypeDao = DaoFactory.approchTypeDao();
    private DetailDao directionDao = DaoFactory.directionDao();
    private DetailDao equipmentDao = DaoFactory.equipmentDao();
    private DetailDao levelDao = DaoFactory.levelDao();
    private DetailDao rockTypeDao = DaoFactory.rockTypeDao();
    private DetailDao routProfilDao = DaoFactory.routProfilDao();
    private DetailDao equipmentQualityDao = DaoFactory.equipmentQualityDao();
    private DetailDao averageRoutNumberDao = DaoFactory.averageRoutNumberDao();

    public  AllDetailList getAllDetail(){
        return new AllDetailList(levelDao.findAll(),directionDao.findAll(),rockTypeDao.findAll(),routProfilDao.findAll(),approchTypeDao.findAll(),equipmentDao.findAll(),equipmentQualityDao.findAll(),averageRoutNumberDao.findAll());
    }
}
