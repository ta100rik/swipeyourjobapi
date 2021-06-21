package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.BuggDao;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.companyDao;
import com.Swipeyourjob.Rest_api.domain.Company.Company;

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
    public Company getCompanydetailsByEstablishment(int establishmentid){
        try {
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM swipeyourjob2.companies com " +
                    "join establishment est " +
                    "on est.companies_company_id = com.company_id " +
                    "and est.idestablishment = ? limit 1");
            preparedStatement.setInt(1,establishmentid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            while (result.next()){
                int company_id = result.getInt("company_id");
                String companylogo = result.getString("companylogo");
                String name = result.getString("name");
                int kvk = result.getInt("kvk");
                return new Company(company_id,companylogo,name,kvk);
            }
        }catch (Exception e){
            return null;
        }
        return  null;
    }
    public boolean updateLogoByEstablishmentid(int establishmentid, String logo){
        try{

            Company company = this.getCompanydetailsByEstablishment(establishmentid);
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE companies set companylogo = ? where company_id = ?");
            preparedStatement.setString(1,logo);
            preparedStatement.setInt(2,company.getCompany_id());
            boolean update = super.updateQuery(preparedStatement,connection);
            return update;
        }catch (Exception e){
            return false;
        }

    }
}
