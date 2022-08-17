package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.ClimbingSpot;
import fr.nikotiine.grimper.api.bo.details.AllDetailList;
import fr.nikotiine.grimper.api.dal.DAO;
import fr.nikotiine.grimper.api.dal.DaoFactory;
import fr.nikotiine.grimper.api.service.DetailService;

public class ClimbingSpotController {
    private DetailService service = DetailService.getInstance();
    private DAO<ClimbingSpot> climbingSpotDAO = DaoFactory.climbingSpotDAO();
    private static ClimbingSpotController instance;
    public static ClimbingSpotController getInstance(){
        if(instance == null){
            return instance = new ClimbingSpotController();
        }
        return instance;
    }

    private ClimbingSpotController() {

    }

public AllDetailList getAllDetails(){
        return service.getAllDetail();
}
public void createNewSpot(ClimbingSpot spot) throws ApiException {
        climbingSpotDAO.findOrCreate(spot);
}
}
