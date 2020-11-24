package com.CartService.cartService.Services;

import com.CartService.cartService.dataLayer.DataAccessObjectsMySQL.DaoImpl.LikeDaoimpl;
import com.CartService.cartService.domain.AppViews.AppCard;
import com.CartService.cartService.domain.AppViews.AppCompanyinfo;
import com.CartService.cartService.domain.AppViews.AppJobInfo;
import com.CartService.cartService.domain.AppViews.AppLocation;
import com.CartService.cartService.domain.Card;
import com.CartService.cartService.domain.CardImage;
import com.CartService.cartService.domain.ListClasses.Cardlist;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private final LikeDaoimpl LikeImpl = new LikeDaoimpl();
//    app
    public int newLike(int userid, int cardid){
        return LikeImpl.newLike(userid,cardid);
    }
    public int newShowed(String userid, int cardid){
        return LikeImpl.newShowed(userid,cardid);
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
    public List<AppCard> getAppcardByUserid(String userid, String start, String amount){
        Cardlist result  = LikeImpl.getCardsByUserid(userid,start,amount);
        List<AppCard> cardlist = new ArrayList<>();

        for (Card currentcard : result.getCardList())
        {
//            initiliaze the company info
            AppCompanyinfo companyinfo = new AppCompanyinfo(currentcard.getCompanyname(), currentcard.getCompanyDescription(),currentcard.getCompanyUrl(),currentcard.getOwner());

            AppLocation location       = new AppLocation(currentcard.getLocation().getCity(),currentcard.getLocation().getStreetname(),currentcard.getLocation().getHousenumber(),currentcard.getLocation().getZipcode());
            AppJobInfo     jobinfo     = new AppJobInfo(currentcard.getCardid(), currentcard.getCardtitle(), currentcard.getDescription(),currentcard.getSalary(),currentcard.getMinHours(),currentcard.getMaxhours(),location);
//            AppJobInfo newcard = new AppJobInfo(currentcard.getCardid(),currentcard.getCardTitel(),currentcard.getDescription(), currentcard.getCity(),currentcard.getCompanyname());
            for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
                jobinfo.addImage(cardimage.getImageurl());
            }
            AppCard newcard = new AppCard(companyinfo,jobinfo);
            cardlist.add(newcard);
        }
        return cardlist;
    }

    public Cardlist getCards(){
        return LikeImpl.getCards();
    }

    //    web
    public int newCard(String cardtitle, String city, String companyname, String description,List<String> images ) {return LikeImpl.newCard(cardtitle,city,companyname,description,images); }
}
