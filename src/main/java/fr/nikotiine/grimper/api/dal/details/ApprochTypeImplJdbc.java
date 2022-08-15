package fr.nikotiine.grimper.api.dal.details;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.details.ApprochType;
import fr.nikotiine.grimper.api.bo.details.Level;
import fr.nikotiine.grimper.api.dal.ConnectionProvider;
import fr.nikotiine.grimper.api.dal.DetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprochTypeImplJdbc implements DetailDao<ApprochType> {
    private final String FIND_ALL = "SELECT * FROM APPROCH_TYPES";
    @Override
    public void findOrCreate(ApprochType object) throws ApiException {

    }

    @Override
    public ApprochType findByPk(int id) {
        return null;
    }

    @Override
    public List<ApprochType> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ApprochType> approchTypeList = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
                ApprochType approchType = new ApprochType(rs.getInt("id_approch_type"),rs.getString("type"));
                approchTypeList.add(approchType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return approchTypeList;
    }


    @Override
    public int update(ApprochType object) throws ApiException {
        return 0;
    }
}
