package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.EquipmentQuality;
import fr.nikotiine.grimper.api.bo.details.RockType;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquimentQualityImplJdbc implements DetailDao<EquipmentQuality> {
    private final String FIND_ALL = "SELECT * FROM EQUIPMENTS_QUALITY";
    @Override
    public void findOrCreate(EquipmentQuality object) throws ApiException {

    }

    @Override
    public EquipmentQuality findByPk(int id) {
        return null;
    }

    @Override
    public List<EquipmentQuality> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<EquipmentQuality> equipmentQualityList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                EquipmentQuality equipmentQuality = new EquipmentQuality(rs.getInt("id_equipment_quality"),rs.getString("quality"));
               equipmentQualityList.add(equipmentQuality);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipmentQualityList;
    }

    @Override
    public int update(EquipmentQuality object) throws ApiException {
        return 0;
    }
}
