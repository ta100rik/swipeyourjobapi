package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.domain.Companyinfo.Company;

public interface CompanyDao {
    Company newCompany(String companyName, String weburl, String Companylogo,String desc);
     
}
