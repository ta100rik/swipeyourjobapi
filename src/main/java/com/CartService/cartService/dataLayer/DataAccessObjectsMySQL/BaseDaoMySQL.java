package com.CartService.cartService.dataLayer.DataAccessObjectsMySQL;

import com.CartService.cartService.dataLayer.BaseDaoConnectionPoolingMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaoMySQL {

    public Connection getConnection(){
        return BaseDaoConnectionPoolingMySQL.getInstance().getConnection();
    }

    public ResultSet executeQuery(PreparedStatement preparedStatement, Connection connection){
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
            return resultSet;
        }
        catch (NullPointerException | SQLException e){

            System.out.println(e);
            System.out.println("Something went wrong. Please check your query." + preparedStatement.toString());
            BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
            return resultSet;
        }
    }

    public Boolean updateQuery(PreparedStatement preparedStatement, Connection connection){
        ResultSet resultSet = null;
        try {
            Boolean result = preparedStatement.execute();
            BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
            return true;
        }
        catch (NullPointerException | SQLException e){

//            System.out.println(e);
            System.out.println("Something went wrong. Please check your query." + preparedStatement.toString());
            BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
            return false;
        }
    }


    public int executeQueryReturningId(PreparedStatement preparedStatement,Connection connection){
        ResultSet resultSet = null;
        try{
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
                return resultSet.getInt(1);
            }
        }
        catch (Exception e){
            System.out.println("[   STACKTRACE  ]");
            e.printStackTrace();
            System.out.println("[   STACKTRACE ]");
            BaseDaoConnectionPoolingMySQL.getInstance().releaseConnection(connection);
            return 0;
        }
        return 0;
    }
}
