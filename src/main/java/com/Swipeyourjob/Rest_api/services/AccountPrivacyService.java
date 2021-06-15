package com.Swipeyourjob.Rest_api.services;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPrivacy;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.AccountPrivacyDaoImpl;

public class AccountPrivacyService {
    AccountPrivacyDaoImpl AccountPrivacyImpl = new AccountPrivacyDaoImpl();
    public AppPrivacy accountPrivacy(String userid, boolean showedjobs, boolean chats, boolean likejobs, boolean bookmarks){
        boolean showedjobsResult = false;
        boolean chatsResult = false;
        boolean likeResult = false;
        boolean bookmarksResult = false;
        if(showedjobs){
            showedjobsResult = AccountPrivacyImpl.removeShowedJobs(userid);
        }
        if(chats){
            chatsResult = AccountPrivacyImpl.removeChatmessages(userid);
        }
        if(likejobs){
            likeResult =  AccountPrivacyImpl.removeLikejobs(userid);
        }
        if(bookmarks){
            bookmarksResult = AccountPrivacyImpl.removeBookmarks(userid);
        }
        AppPrivacy privacy = new AppPrivacy(showedjobsResult,chatsResult,likeResult,bookmarksResult);
        return privacy;

    }
}
