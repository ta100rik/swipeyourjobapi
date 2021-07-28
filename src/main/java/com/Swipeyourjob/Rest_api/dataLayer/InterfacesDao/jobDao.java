package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.Controllers.request.NewJobRequest;
import com.Swipeyourjob.Rest_api.ResultClass;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Job;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Joblist;

import java.sql.Connection;

public interface jobDao {
    Job getCardByJobid(String jobid);
    Joblist getCardsByUserid(String userid, String start, String amount);
    Joblist getCardsbyBookmark(String userid);
    int getBookmarkAmountuser(String userid);
    CardImageList getCardimagesByCardid(int cardid, Connection connection);
    ResultClass getCardsByCompanyUserid(int Companyid);
    ResultClass newJobHandler(NewJobRequest req, int companyid);
    ResultClass getLikedJobs(int webuserid,String filter);
    ResultClass getLikedJobs(int webuserid,String filter,int jobid);
}
