package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.DaoImpl.JobDaoImpl;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCard;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCompanyinfo;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppJobInfo;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppLocation;
import com.Swipeyourjob.Rest_api.domain.Card;
import com.Swipeyourjob.Rest_api.domain.CardImage;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private final JobDaoImpl JobImpl = new JobDaoImpl();
//    app
    public int newLike(int userid, int cardid){
        return JobImpl.newLike(userid,cardid);
    }
    public int newShowed(String userid, int cardid){
        return JobImpl.newShowed(userid,cardid);
    }
    public List<AppJobInfo> getAppCards(){
//        Cardlist result  = LikeImpl.getCards();
//        List<String> images = new ArrayList<>();
//        List<AppJobInfo> cardlist = new ArrayList<>();
//
//        for (Card currentcard : result.getCardList())
//        {
//            AppJobInfo newcard = new AppJobInfo(currentcard.getCardid(),currentcard.getCardTitel(),currentcard.getDescription(), currentcard.getCity(),currentcard.getCompanyname());
//            for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
//                newcard.addImage(cardimage.getImageurl());
//            }
//            cardlist.add(newcard);
//        }
        return null;
    }
    public List<AppCard> getAppcardByUserid(String userid, String start, String amount,String lon, String lat){

        Cardlist result  = JobImpl.getCardsByUserid(userid,start,amount);

        List<AppCard> cardlist = new ArrayList<>();
        List<String> images = new ArrayList<>();
        for (Card currentcard : result.getCardList())
        {
//            initiliaze the company info
            AppCompanyinfo companyinfo = new AppCompanyinfo(currentcard.getCompanyname(), currentcard.getCompanyDescription(),currentcard.getCompanyUrl(),currentcard.getOwner());

            AppLocation location       = new AppLocation(currentcard.getLocation().getCity(),currentcard.getLocation().getStreetname(),currentcard.getLocation().getHousenumber(),currentcard.getLocation().getZipcode(),currentcard.getLocation().getJoblongtitude(),currentcard.getLocation().getJoblatitude());
            if(!lon.isEmpty() && !lat.isEmpty()){
                currentcard.getLocation().setJobdistance(lon,lat);
                location.setJobdistance(currentcard.getLocation().getJobdistance());
            }

            AppJobInfo     jobinfo     = new AppJobInfo(currentcard.getCardid(), currentcard.getCardtitle(), currentcard.getDescription(),currentcard.getSalary(),currentcard.getMinHours(),currentcard.getMaxhours());
           for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
               images.add(cardimage.getImageurl());
           }

            AppCard newcard = new AppCard(companyinfo,jobinfo,images,location);
            cardlist.add(newcard);
        }
        return cardlist;
    }

    public Cardlist getCards(){
        return JobImpl.getCards();
    }

    //    web
    public int newCard(String cardtitle, String city, String companyname, String description,List<String> images ) {return JobImpl.newCard(cardtitle,city,companyname,description,images); }
}
