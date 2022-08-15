package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.RockType;
import fr.nikotiine.grimper.api.bo.details.RoutProfil;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoutProfilImplJdbc implements DetailDao<RoutProfil> {
    private final String FIND_ALL = "SELECT * FROM ROUT_PROFILS";
    @Override
    public void findOrCreate(RoutProfil object) throws ApiException {

    }

    @Override
    public RoutProfil findByPk(int id) {
        return null;
    }

    @Override
    public List<RoutProfil> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RoutProfil> routProfilList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                RoutProfil routProfil = new RoutProfil(rs.getInt("id_rout_profil"),rs.getString("profil"));
                routProfilList.add(routProfil);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return routProfilList;
    }

    @Override
    public int update(RoutProfil object) throws ApiException {
        return 0;
    }
}
