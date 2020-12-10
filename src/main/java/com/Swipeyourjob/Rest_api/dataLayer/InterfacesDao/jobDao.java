package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.util.List;

public interface jobDao {
    int newLike(int userid, int cardid);
    Cardlist getCards();
    Cardlist getCardsByUserid(String userid, String start, String amount);
}
