package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.ClimbingSpot;
import fr.nikotiine.grimper.api.bo.ClimbingSpotSecteur;

import java.sql.*;
import java.util.List;

public class ClimbingSpotImplJdbc implements DAO<ClimbingSpot> {
    private final String CREATE_SPOT ="INSERT INTO CLIMBING_SPOT (name, id_minimum_level, id_maximum_level, average_height, approach_time, id_approach_type, id_equipment, id_equipment_quality, id_direction, id_rock_type, id_rout_profil, id_average_rout, nb_secteurs, latitude_P1, longitude_P1, latitude_P2, longitude_P2, reseau_4g, water, toilette, river) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    private final String ADD_SECTEUR ="INSERT INTO SECTEURS (name,id_spot) VALUES (?,?)";
    private final String FIND_SPOT="SELECT COUNT(*) as total FROM CLIMBING_SPOT WHERE name=?";
    @Override
    public void findOrCreate(ClimbingSpot spot) throws ApiException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean findSpot = findInDb(this.FIND_SPOT,spot.getName());
        if(findSpot){
            throw new ApiException(CodeErrorDal.SPOT_EXISTANT);
        }
        try(Connection cnx = ConnectionProvider.getConnection()) {
            System.out.println("try spotimpl new");
            ps = cnx.prepareStatement(this.CREATE_SPOT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,spot.getName());
            ps.setInt(2,spot.getIdMinimumLevel());
            ps.setInt(3,spot.getIdMaximumLevel());
            ps.setInt(4,spot.getAverageHeight());
            ps.setInt(5,spot.getApproachTime());
            ps.setInt(6,spot.getIdApproachType());
            ps.setInt(7,spot.getIdEquipment());
            ps.setInt(8,spot.getIdEquimentQuality());
            ps.setInt(9,spot.getIdDirection());
            ps.setInt(10,spot.getIdRockType());
            ps.setInt(11,spot.getIdRoutProfil());
            ps.setInt(12,spot.getIdAverageRout());
            ps.setInt(13,spot.getNbSecteur());
            ps.setDouble(14,spot.getLatitudeP1());
            ps.setDouble(15,spot.getLongitudeP1());
            if(spot.getLatitudeP2()!=null && spot.getLatitudeP2()!=null){
                ps.setDouble(16,spot.getLatitudeP2());
                ps.setDouble(17,spot.getLongitudeP2());
            }else {

              ps.setNull(16, Types.NULL);
              ps.setNull(17,Types.NULL);
            }

            ps.setBoolean(18,spot.isReseau4g());
            ps.setBoolean(19,spot.isWater());
            ps.setBoolean(20,spot.isToilette());
            ps.setBoolean(21,spot.isRiver());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if(rs.next()){
                addSecteur(rs.getInt(1),spot.getSecteurs());
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    public ClimbingSpot findByPk(int id) {
        return null;
    }

    @Override
    public List<ClimbingSpot> findAll() {
        return null;
    }

    @Override
    public int update(ClimbingSpot object) throws ApiException {
        return 0;
    }

    private boolean findInDb(String findSqlQuery, String lookupString)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isFind = false;
        try(Connection cnx = ConnectionProvider.getConnection()){
            ps = cnx.prepareStatement(findSqlQuery);
            ps.setString(1,lookupString);
            rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getInt("total")>0){
                    isFind = true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isFind;
    }


    private void addSecteur(int spotId, List<ClimbingSpotSecteur> secteurs) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection cnx = ConnectionProvider.getConnection()) {
            System.out.println("secteur");
            ps = cnx.prepareStatement(this.ADD_SECTEUR);
            for (ClimbingSpotSecteur secteur:secteurs
                 ) {
                ps.setString(1,secteur.getName());
                ps.setInt(2,spotId);
                ps.executeUpdate();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
