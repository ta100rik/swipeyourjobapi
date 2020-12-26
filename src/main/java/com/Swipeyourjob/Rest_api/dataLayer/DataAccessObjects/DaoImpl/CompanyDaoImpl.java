package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.CompanyDao;
import com.Swipeyourjob.Rest_api.domain.Companyinfo.Company;

public class CompanyDaoImpl extends BaseDaoMySQL implements CompanyDao {

    @Override
    public Company newCompany(String companyName, String weburl, String Companylogo, String desc) {
        return null;
    }
}
