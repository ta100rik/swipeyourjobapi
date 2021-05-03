package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.BuggDao;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.companyDao;

import java.sql.*;

public class CompanyDaoImpl extends BaseDaoMySQL implements companyDao {
    @Override
    public int createCompany(String name, String kvk) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement insertreadstatement = connection.prepareStatement("INSERT INTO companies(name,kvk) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            insertreadstatement.setString(1,name);
            insertreadstatement.setString(2,kvk);
            return super.executeQueryReturningId(insertreadstatement,connection);
        } catch (SQLException w){
            return -1;
        } catch (Exception e){
            return 0;
        }
    }
}
