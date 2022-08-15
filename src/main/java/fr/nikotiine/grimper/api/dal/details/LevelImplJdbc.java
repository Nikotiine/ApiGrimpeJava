package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.Level;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelImplJdbc implements DetailDao<Level> {

private final String FIND_ALL = "SELECT * FROM LEVELS";
    @Override
    public void findOrCreate(Level object) throws ApiException {

    }

    @Override
    public Level findByPk(int id) {
        return null;
    }

    @Override
    public List<Level> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Level> levelList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                Level level = new Level(rs.getInt("id_level"),rs.getString("designation"));
                levelList.add(level);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return levelList;
    }

    @Override
    public int update(Level object) throws ApiException {
        return 0;
    }
}
