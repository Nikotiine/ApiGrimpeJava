package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.Direction;
import fr.nikotiine.grimper.api.bo.details.Equipment;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentImplJdbc implements DetailDao<Equipment> {
    private final String FIND_ALL = "SELECT * FROM EQUIPMENTS";
    @Override
    public void findOrCreate(Equipment object) throws ApiException {

    }

    @Override
    public Equipment findByPk(int id) {
        return null;
    }

    @Override
    public List<Equipment> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Equipment> equipmentList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                Equipment equipment = new Equipment(rs.getInt("id_equipment"),rs.getString("libelle"));
                equipmentList.add(equipment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipmentList;
    }

    @Override
    public int update(Equipment object) throws ApiException {
        return 0;
    }
}
