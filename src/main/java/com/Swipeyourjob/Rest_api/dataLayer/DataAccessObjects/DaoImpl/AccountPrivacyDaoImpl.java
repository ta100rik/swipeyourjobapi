package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.AccountPrivacyDao;
import com.Swipeyourjob.Rest_api.domain.ListClasses.GuestList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AccountPrivacyDaoImpl extends BaseDaoMySQL implements AccountPrivacyDao {

    public boolean removeShowedJobs(String userid){
        String sql = "";
        try{
                Connection connection  = super.getConnection();
                sql = "delete from showedjobs where userid = ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,userid);
                super.updateQuery(preparedStatement,connection);
                return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeBookmarks(String userid){
        String sql = "";
        try{
            Connection connection  = super.getConnection();
            sql = "delete from bookmarkedjobs where userid = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userid);
            super.updateQuery(preparedStatement,connection);
            return true;
        }
        catch (Exception e){
            System.out.println(sql);
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeChatmessages(String userid){
        String sql = "";
        try{
            Connection connection  = super.getConnection();
            sql = "delete from chatmessages where userid = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userid);
            super.updateQuery(preparedStatement,connection);
            return true;
        }
        catch (Exception e){
            System.out.println(sql);
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeLikejobs(String userid){
        String sql = "";
        try{
            Connection connection  = super.getConnection();
            sql = "delete from likedjobs where userid = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userid);
            super.updateQuery(preparedStatement,connection);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
