package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.IdenticationDao;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IdenticationDaoImpl extends BaseDaoMySQL implements IdenticationDao {
    public String getHashedPassword(String username){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password from webusers where username = ?");
            preparedStatement.setString(1,username);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            int rows    = getRowCount(result);
            if(rows == 1){
                while(result.next()){
                    return result.getString("password");
                }
            }else{
                return "False";
            }
        }catch (Exception e){
            System.out.println(e);
            return "False";
        }
        return "False";
    }
    public WebUser getWebuserByEmail(String email){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM webusers join userroles on userroles.iduserroles = webusers.roleid and webusers.email = ?");
            preparedStatement.setString(1,email);
            ResultSet result    = super.executeQuery(preparedStatement,connection);
            int rowCount        = super.getRowCount(result);
            if(rowCount != 0){
                while(result.next()){
                    int db_userid      = result.getInt("idwebusers");
                    String db_email  = result.getString("email");
                    String db_firstname = result.getString("firstname");
                    String db_lastname  = result.getString("lastname");
                    String db_role      = result.getString("rolename");
                    WebUser user        = new WebUser(db_userid,db_email,db_firstname,db_lastname,db_role);
                    return user;
                }
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
    @Override
    public WebUser registerWebUser(String email, String password, int roleid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO webusers (email, password, roleid) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.setInt(3,roleid);
            int returnedid = super.executeQueryReturningId(preparedStatement,connection);
            WebUser webuser = new WebUser(email,returnedid,"admin");
            return webuser;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
