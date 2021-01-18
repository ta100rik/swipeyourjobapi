package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.CompanyDao;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.IdenticationDao;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class IdenticationDaoImpl extends BaseDaoMySQL implements IdenticationDao {
    @Override
    public WebUser registerWebUser(String username, String password, String firstname, String lastname, int companyid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO webusers (username, password, firstname,lastname,companyid) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,firstname);

            preparedStatement.setString(4,lastname);
            preparedStatement.setInt(5,companyid);
            int returnedid = super.executeQueryReturningId(preparedStatement,connection);
            WebUser webuser = new WebUser(username,firstname,lastname,companyid,returnedid);
            return webuser;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
