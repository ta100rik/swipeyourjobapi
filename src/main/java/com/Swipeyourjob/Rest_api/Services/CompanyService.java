package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.CompanyDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.EstamblishmentDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;

public class CompanyService {
     CompanyDaoImpl companyservice = new CompanyDaoImpl();
     EstamblishmentDaoImpl estamblishmentservice = new EstamblishmentDaoImpl();
     public int createcompany(String name, String kvk){
         return companyservice.createCompany(name,kvk);
    }

    public int createEstamblishment(int companyid, int userid, String name,String zipcode,int defaultlocation){
        return estamblishmentservice.createEstamblishment(name,defaultlocation,companyid,userid,zipcode);
    }
}
