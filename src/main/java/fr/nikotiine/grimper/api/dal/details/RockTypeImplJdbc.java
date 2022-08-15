package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.Equipment;
import fr.nikotiine.grimper.api.bo.details.RockType;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RockTypeImplJdbc implements DetailDao<RockType> {
    private final String FIND_ALL = "SELECT * FROM ROCK_TYPES";
    @Override
    public void findOrCreate(RockType object) throws ApiException {

    }

    @Override
    public RockType findByPk(int id) {
        return null;
    }

    @Override
    public List<RockType> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RockType> rockTypeList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                RockType rockType = new RockType(rs.getInt("id_rock_types"),rs.getString("type"));
                rockTypeList.add(rockType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rockTypeList;
    }

    @Override
    public int update(RockType object) throws ApiException {
        return 0;
    }
}
