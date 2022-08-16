package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.AverageRoutNumber;
import fr.nikotiine.grimper.api.bo.details.EquipmentQuality;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AverageRoutNumberImplJdbc implements DetailDao<AverageRoutNumber> {
    private final String FIND_ALL = "SELECT * FROM AVERAGE_ROUT_NUMBERS";
    @Override
    public void findOrCreate(AverageRoutNumber object) throws ApiException {

    }

    @Override
    public AverageRoutNumber findByPk(int id) {
        return null;
    }

    @Override
    public List<AverageRoutNumber> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AverageRoutNumber> averageRoutNumberList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                AverageRoutNumber averageRoutNumber = new AverageRoutNumber(rs.getInt("id_average_rout"),rs.getString("libelle"));
                averageRoutNumberList.add(averageRoutNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return averageRoutNumberList;
    }

    @Override
    public int update(AverageRoutNumber object) throws ApiException {
        return 0;
    }
}
