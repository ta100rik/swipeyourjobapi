package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.CompanyDao;
import com.Swipeyourjob.Rest_api.domain.Companyinfo.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CompanyDaoImpl extends BaseDaoMySQL implements CompanyDao {

    @Override
    public Company newCompany(String companyName, String weburl, String Companylogo, String desc) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO companies (name,comanydesc,weburl,companylogo) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,companyName);
            preparedStatement.setString(2,desc);
            preparedStatement.setString(3,weburl);
            preparedStatement.setString(4,Companylogo);
            int databaseID = super.executeQueryReturningId(preparedStatement,connection);
            Company newcompany = new Company(databaseID,desc,companyName,weburl,Companylogo);
            return newcompany;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
