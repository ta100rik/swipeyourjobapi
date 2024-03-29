package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.CompanyDao;
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
    public WebUser getWebuserByUsername(String username){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM webusers join userroles on userroles.iduserroles = webusers.roleid");
            ResultSet result    = super.executeQuery(preparedStatement,connection);
            int rowCount        = super.getRowCount(result);
            if(rowCount != 0){
                while(result.next()){
                    String db_username  = result.getString("username");
                    String db_firstname = result.getString("firstname");
                    String db_lastname  = result.getString("lastname");
                    int db_companyid    = result.getInt("companyid");
                    int db_userid       = result.getInt("idwebusers");
                    String db_role      = result.getString("rolename");
                    WebUser user        = new WebUser(db_username,db_firstname,db_lastname,db_companyid,db_userid,db_role);
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
            WebUser webuser = new WebUser(username,firstname,lastname,companyid,returnedid,"companyadmin");
            return webuser;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
