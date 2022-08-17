package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.bo.ClimbingSpotDto;

import java.util.List;

public interface JsonDao {
    List<ClimbingSpotDto> getAllSpot();

    ClimbingSpotDto getOneSpot(int idSpot);
}
