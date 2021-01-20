package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.BuggDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuggDaoImpl  extends BaseDaoMySQL implements BuggDao {
    @Override
    public int newBug(String userid, String username,String description, String versionnumber){
            try{
                Connection connection  = super.getConnection();
                String query = "INSERT INTO bugs (userid,username,description,versionnumber) VALUES (?,?,?,?)";
                PreparedStatement insertreadstatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                insertreadstatement.setString(1,userid);
                insertreadstatement.setString(2,username);
                insertreadstatement.setString(3,description);
                insertreadstatement.setString(4,versionnumber);
                int bugnumber = super.executeQueryReturningId(insertreadstatement,connection);
                return bugnumber;
            }
            catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }


}
