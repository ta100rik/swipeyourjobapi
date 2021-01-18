package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCompany;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.CompanyDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.JobDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Companyinfo.Company;

public class CompanyService {
    private final CompanyDaoImpl companyImp = new CompanyDaoImpl();
    public int createCompany(String desc, String name, String webUrl, String companyLogo){
        Company newCompany =  companyImp.newCompany(name,webUrl,companyLogo,desc);
        return newCompany.getCompanyid();
    }
}
