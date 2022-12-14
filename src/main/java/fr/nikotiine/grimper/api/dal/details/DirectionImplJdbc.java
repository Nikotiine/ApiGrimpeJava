package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.ApprochType;
import fr.nikotiine.grimper.api.bo.details.Direction;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectionImplJdbc implements DetailDao<Direction> {
    private final String FIND_ALL = "SELECT * FROM DIRECTIONS";
    @Override
    public void findOrCreate(Direction object) throws ApiException {

    }

    @Override
    public Direction findByPk(int id) {
        return null;
    }

    @Override
    public List<Direction> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Direction> directionList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                Direction direction = new Direction(rs.getInt("id_direction"),rs.getString("direction"));
                directionList.add(direction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return directionList;
    }

    @Override
    public int update(Direction object) throws ApiException {
        return 0;
    }
}
