package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.bo.details.AllDetailList;
import fr.nikotiine.grimper.api.service.DetailService;

public class ClimbingSpotController {
    private DetailService service = DetailService.getInstance();
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
}
