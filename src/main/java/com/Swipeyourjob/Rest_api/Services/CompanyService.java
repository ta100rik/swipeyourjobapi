package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebCompanyProfile;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.CompanyDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.EstamblishmentDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Company.EstamblishmentProfile;

public class CompanyService {
     CompanyDaoImpl companyservice = new CompanyDaoImpl();
     EstamblishmentDaoImpl estamblishmentservice = new EstamblishmentDaoImpl();
     public int createcompany(String name, String kvk){
         return companyservice.createCompany(name,kvk);
    }

    public int createEstamblishment(int companyid, int userid, String name,String zipcode,int defaultlocation){
        int estamblishmentid = estamblishmentservice.createEstamblishment(name,defaultlocation,companyid,userid,zipcode);
        if(estamblishmentid > 0){
            boolean userconnection = estamblishmentservice.WebUsertoEstamblishment(userid,estamblishmentid);
            System.out.println(userconnection);
            if(!userconnection){
                return -2;
            }
        }
        return estamblishmentid;
     }
     public WebCompanyProfile getCompanyProfile(int estamblishmentid){
         try{
             EstamblishmentProfile profile = estamblishmentservice.getEstamblishmentProfile(estamblishmentid);
             WebCompanyProfile webprofile = new WebCompanyProfile(
                     profile.getIntroduction(),
                     profile.getLogo(),
                     profile.getOwnerFirstName(),
                     profile.getOwnerLastname(),
                     profile.getOwnerPicture(),
                     profile.getInstagramUrl(),
                     profile.getLinkedinUrl(),
                     profile.getFacebookUrl(),
                     profile.getPlace(),
                     profile.getStreetname(),
                     profile.getHousenumber(),
                     profile.getZipcode());
             return webprofile;
         }catch (Exception e){
            return  null;
         }
     }
     public boolean hasEstamblishmentAccess(int userid, int estamblishmentid){
         return estamblishmentservice.WebUserAcces(userid,estamblishmentid);
     }
}
