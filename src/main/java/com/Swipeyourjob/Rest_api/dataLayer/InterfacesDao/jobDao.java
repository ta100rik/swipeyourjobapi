package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.Controllers.request.NewJobRequest;
import com.Swipeyourjob.Rest_api.ResultClass;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Card;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.sql.Connection;

public interface jobDao {
    Card getCardByJobid(String jobid);
    Cardlist getCardsByUserid(String userid, String start, String amount);
    Cardlist getCardsbyBookmark(String userid);
    int getBookmarkAmountuser(String userid);
    CardImageList getCardimagesByCardid(int cardid, Connection connection);
    Cardlist getCardsByCompanyId(int Companyid);
    ResultClass newJobHandler(NewJobRequest req, int companyid);
}
