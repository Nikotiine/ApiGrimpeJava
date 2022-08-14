package fr.nikotiine.grimper.api.controller;

public class ClimbingSpotController {
    private static ClimbingSpotController instance;
    public static ClimbingSpotController getInstance(){
        if(instance == null){
            return instance = new ClimbingSpotController();
        }
        return instance;
    }

    private ClimbingSpotController() {
    }


}
