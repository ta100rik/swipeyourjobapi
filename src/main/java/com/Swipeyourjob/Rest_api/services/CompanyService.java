package com.Swipeyourjob.Rest_api.services;

import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebCompanyProfile;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebEstablishmentItem;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.CompanyDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.EstamblishmentDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Company.Company;
import com.Swipeyourjob.Rest_api.domain.Company.EstablishmentItem;
import com.Swipeyourjob.Rest_api.domain.Company.EstablishmentProfile;
import com.Swipeyourjob.Rest_api.domain.ListClasses.EstablishmentList;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
     CompanyDaoImpl companyservice = new CompanyDaoImpl();
     IdenticationDaoImpl identicationservice = new IdenticationDaoImpl();
     EstamblishmentDaoImpl establishmentservice = new EstamblishmentDaoImpl();
     public int createcompany(String name, String kvk){
         return companyservice.createCompany(name,kvk);
    }

    public int createEstamblishment(int companyid, int userid, String name,String zipcode,int defaultlocation){
        int estamblishmentid = establishmentservice.createEstamblishment(name,defaultlocation,companyid,userid,zipcode);
        if(estamblishmentid > 0){
            boolean userconnection = establishmentservice.WebUsertoEstamblishment(userid,estamblishmentid);
            System.out.println(userconnection);
            if(!userconnection){
                return -2;
            }
        }
        return estamblishmentid;
     }
     public WebCompanyProfile getCompanyProfile(int estamblishmentid){
         try{
             EstablishmentProfile profile = establishmentservice.getEstablishmentProfile(estamblishmentid);

             WebCompanyProfile webprofile = new WebCompanyProfile(
                     profile.getIntroduction(),
                     profile.getLogo(),
                     profile.getOwnerFirstName(),
                     profile.getOwnerLastname(),
                     profile.getOwnerPicture(),
                     profile.getWeburl(),
                     profile.getInstagramUrl(),
                     profile.getLinkedinUrl(),
                     profile.getFacebookUrl(),
                     profile.getPlace(),
                     profile.getStreetname(),
                     profile.getHousenumber(),
                     profile.getZipcode(),
                     estamblishmentid);
             return webprofile;
         }catch (Exception e){
             System.out.println(e.getMessage());
            return  null;
         }
     }
     public Boolean updateEstablishmentProfile(WebCompanyProfile profile,int userid){
       try{

           boolean profielupdate =  establishmentservice.updateEstablishmentProfile(
                   profile.getIntroduction(),
                   profile.getWeburl(),
                   profile.getInstagramUrl(),
                   profile.getLinkedinUrl(),
                   profile.getFacebookUrl(),
                   profile.getPlace(),
                   profile.getStreetname(),
                   profile.getHousenumber(),
                   profile.getZipcode(),
                   profile.getEstablishmentid()
           );
           boolean updateWebUser = identicationservice.updateWebUser(userid,
                   profile.getOwnerFirstName(),
                   profile.getOwnerLastname(),
                   profile.getOwnerPicture());
           System.out.println(updateWebUser);
           boolean updateCompanylogo = companyservice.updateLogoByEstablishmentid(profile.getEstablishmentid(), profile.getLogo());
           return true;
       }catch (Exception e){
           return false;
       }
     }
     public Company getCompanydetailsByEstablishment(int estamblismentid){
         return companyservice.getCompanydetailsByEstablishment(estamblismentid);
     }
     public List<WebEstablishmentItem> userEstablishments(int userid){
         try{
             System.out.println("test");
             EstablishmentList list = establishmentservice.getEstablishmentlistByUser(userid);
             List<WebEstablishmentItem> new_list = new ArrayList<>();
             for(EstablishmentItem item :list.getEstablishmentlist()){
                 WebEstablishmentItem new_item = new WebEstablishmentItem(item.getId(),item.getEstablishmentName());
                 new_list.add(new_item);
             }
             return new_list;
         }catch (Exception e){
             System.out.println(e);
             return null;
         }
     }
     public boolean hasEstablishmentAccess(int userid, int establishmentid){
         return establishmentservice.WebUserAcces(userid,establishmentid);
     }
}
