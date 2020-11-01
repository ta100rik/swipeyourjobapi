package com.CartService.cartService.Services;

import com.CartService.cartService.dataLayer.DataAccessObjectsMySQL.DaoImpl.LikeDaoimpl;
import com.CartService.cartService.domain.AppViews.AppCard;
import com.CartService.cartService.domain.Card;
import com.CartService.cartService.domain.CardImage;
import com.CartService.cartService.domain.ListClasses.CardImageList;
import com.CartService.cartService.domain.ListClasses.Cardlist;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private final LikeDaoimpl LikeImpl = new LikeDaoimpl();
    public int newLike(int userid, int cardid){
        return LikeImpl.newLike(userid,cardid);
    }
    public List<AppCard> getAppCards(){
        Cardlist result  = LikeImpl.getCards();
        List<String> images = new ArrayList<>();
        List<AppCard> cardlist = new ArrayList<>();

        for (Card currentcard : result.getCardList())
        {
            AppCard newcard = new AppCard(currentcard.getCardid(),currentcard.getCardTitel(),currentcard.getDescription(), currentcard.getCity(),currentcard.getCompanyname());
            for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
                newcard.addImage(cardimage.getImageurl());
            }
            cardlist.add(newcard);
        }
        return cardlist;
    }
    public Cardlist getCards(){
        return LikeImpl.getCards();
    }

    public int newCard(String cardtitle, String city, String companyname) {return LikeImpl.newCard(cardtitle,city,companyname); }
}
