package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Card;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.sql.Connection;

public interface jobDao {
    int newBookmark(String userid, int cardid);
    int newLike(String userid, int cardid);

    Card getCardByJobid(String jobid);
    CardImageList getCardimagesByCardid(int cardid, Connection connection);
    Cardlist getCardsByUserid(String userid, String start, String amount);
    int newShowed( String userid, int cardid);
}
