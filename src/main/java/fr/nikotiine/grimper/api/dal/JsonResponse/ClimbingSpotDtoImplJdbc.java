package fr.nikotiine.grimper.api.dal.JsonResponse;

import fr.nikotiine.grimper.api.bo.ClimbingSpotDto;
import fr.nikotiine.grimper.api.bo.ClimbingSpotSecteur;
import fr.nikotiine.grimper.api.bo.details.*;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DtoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClimbingSpotDtoImplJdbc implements DtoDao {
    private final String GET_ALL_SPOT ="SELECT id_spot,name,average_height,approach_time,nb_secteurs,direction,E.libelle as equipment,ARN.libelle as averageRout ,quality,profil,LVS.designation as maximumLevel,LVS2.designation as minimumLevel,RT.type as rockType,ATS.type as approachType,latitude_P1,longitude_P1,latitude_P2,longitude_P2,reseau_4g,toilette,water,river FROM CLIMBING_SPOT CS JOIN DIRECTIONS D on CS.id_direction = D.id_direction JOIN EQUIPMENTS E on CS.id_equipment = E.id_equipment JOIN AVERAGE_ROUT_NUMBERS ARN on CS.id_average_rout = ARN.id_average_rout JOIN EQUIPMENTS_QUALITY EQ on CS.id_equipment_quality = EQ.id_equipment_quality JOIN ROUT_PROFILS RP on CS.id_rout_profil = RP.id_rout_profil JOIN LEVELS LVS on CS.id_maximum_level = LVS.id_level JOIN LEVELS LVS2 on CS.id_minimum_level = LVS2.id_level JOIN ROCK_TYPES RT on CS.id_rock_type = RT.id_rock_types JOIN APPROCH_TYPES ATS on CS.id_approach_type = ATS.id_approch_type";
    private final String GET_SECTEUR_OF_SPOT="SELECT * FROM SECTEURS WHERE id_spot=?";
    private final String GET_ONE_SPOT="SELECT id_spot,name,average_height,approach_time,nb_secteurs,direction,E.libelle as equipment,ARN.libelle as averageRout ,quality,profil,LVS.designation as maximumLevel,LVS2.designation as minimumLevel,RT.type as rockType,ATS.type as approachType,latitude_P1,longitude_P1,latitude_P2,longitude_P2,reseau_4g,toilette,water,river FROM CLIMBING_SPOT CS JOIN DIRECTIONS D on CS.id_direction = D.id_direction JOIN EQUIPMENTS E on CS.id_equipment = E.id_equipment JOIN AVERAGE_ROUT_NUMBERS ARN on CS.id_average_rout = ARN.id_average_rout JOIN EQUIPMENTS_QUALITY EQ on CS.id_equipment_quality = EQ.id_equipment_quality JOIN ROUT_PROFILS RP on CS.id_rout_profil = RP.id_rout_profil JOIN LEVELS LVS on CS.id_maximum_level = LVS.id_level JOIN LEVELS LVS2 on CS.id_minimum_level = LVS2.id_level JOIN ROCK_TYPES RT on CS.id_rock_type = RT.id_rock_types JOIN APPROCH_TYPES ATS on CS.id_approach_type = ATS.id_approch_type WHERE CS.id_spot=?";
   private final String GET_ALL_NAME_SPOT="SELECT name FROM CLIMBING_SPOT";
    @Override
    public List<ClimbingSpotDto> getAllSpot() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClimbingSpotDto> allClimbingSpot =new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.GET_ALL_SPOT);
            rs = ps.executeQuery();
            while (rs.next()){
                int idSpot = rs.getInt("id_spot");
                String name = rs.getString("name");
                int averageHeight = rs.getInt("average_height");
                int approachTime = rs.getInt("approach_time");
                int nbSecteur = rs.getInt("nb_secteurs");
                Direction direction = new Direction(rs.getString("direction"));
                Equipment equipment = new Equipment(rs.getString("equipment"));
                AverageRoutNumber averageRoutNumber = new AverageRoutNumber(rs.getString("averageRout"));
                EquipmentQuality quality = new EquipmentQuality(rs.getString("quality"));
                RoutProfil profil = new RoutProfil(rs.getString("profil"));
                Level max = new Level(rs.getString("maximumLevel"));
                Level min = new Level(rs.getString("minimumLevel"));
                RockType rockType = new RockType(rs.getString("rockType"));
                ApprochType approchType = new ApprochType(rs.getString("approachType"));
                Double latitudeP1 = rs.getDouble("latitude_P1");
                Double longitudeP1 = rs.getDouble("longitude_P1");
                Double latitudeP2 = rs.getDouble("latitude_P2");
                Double longitudeP2 = rs.getDouble("longitude_P2");
                boolean reseau4g = rs.getBoolean("reseau_4g");
                boolean toilette = rs.getBoolean("toilette");
                boolean water = rs.getBoolean("water");
                boolean river = rs.getBoolean("river");
                ClimbingSpotDto spot = new ClimbingSpotDto(idSpot,name,approachTime,averageHeight,nbSecteur,latitudeP1,longitudeP1,latitudeP2,longitudeP2,reseau4g,water,toilette,river,min,max,approchType,direction,equipment,quality,rockType,profil,averageRoutNumber);
                allClimbingSpot.add(spot);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allClimbingSpot;
    }

    @Override
    public ClimbingSpotDto getOneSpot(int idSpot) {
        System.out.println(idSpot);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClimbingSpotSecteur> secteurs = getSecteurOfSpot(idSpot);
        ClimbingSpotDto spot =null;
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.GET_ONE_SPOT);
            ps.setInt(1,idSpot);
            rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int averageHeight = rs.getInt("average_height");
                int approachTime = rs.getInt("approach_time");
                int nbSecteur = rs.getInt("nb_secteurs");
                Direction direction = new Direction(rs.getString("direction"));
                Equipment equipment = new Equipment(rs.getString("equipment"));
                AverageRoutNumber averageRoutNumber = new AverageRoutNumber(rs.getString("averageRout"));
                EquipmentQuality quality = new EquipmentQuality(rs.getString("quality"));
                RoutProfil profil = new RoutProfil(rs.getString("profil"));
                Level max = new Level(rs.getString("maximumLevel"));
                Level min = new Level(rs.getString("minimumLevel"));
                RockType rockType = new RockType(rs.getString("rockType"));
                ApprochType approchType = new ApprochType(rs.getString("approachType"));
                Double latitudeP1 = rs.getDouble("latitude_P1");
                Double longitudeP1 = rs.getDouble("longitude_P1");
                Double latitudeP2 = rs.getDouble("latitude_P2");
                Double longitudeP2 = rs.getDouble("longitude_P2");
                boolean reseau4g = rs.getBoolean("reseau_4g");
                boolean toilette = rs.getBoolean("toilette");
                boolean water = rs.getBoolean("water");
                boolean river = rs.getBoolean("river");
                spot = new ClimbingSpotDto(idSpot,name,approachTime,averageHeight,nbSecteur,latitudeP1,longitudeP1,latitudeP2,longitudeP2,reseau4g,water,toilette,river,min,max,approchType,direction,equipment,quality,rockType,profil,averageRoutNumber,secteurs);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return spot;

    }

    @Override
    public List<String> getAllNameOfClimbingSpot() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> allNameSpot =new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.GET_ALL_NAME_SPOT);
            rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                allNameSpot.add(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allNameSpot;
    }

    private List<ClimbingSpotSecteur> getSecteurOfSpot(int idSpot){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClimbingSpotSecteur> list = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.GET_SECTEUR_OF_SPOT);
            ps.setInt(1,idSpot);
            rs= ps.executeQuery();
            while (rs.next()){
                int idSecteur = rs.getInt("id_secteur");
                String name = rs.getString("name");
                ClimbingSpotSecteur secteur = new ClimbingSpotSecteur(idSecteur,name,idSpot);
                list.add(secteur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
