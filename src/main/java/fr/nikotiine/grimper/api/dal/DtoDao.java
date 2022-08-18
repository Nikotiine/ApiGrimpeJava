package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.bo.ClimbingSpotDto;

import java.util.List;

public interface DtoDao {
    List<ClimbingSpotDto> getAllSpot();

    ClimbingSpotDto getOneSpot(int idSpot);

    List<String> getAllNameOfClimbingSpot();
}
