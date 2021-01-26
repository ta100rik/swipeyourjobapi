package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPrivacy;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.AccountPrivacyDaoImpl;

public class AccountPrivacyService {
    AccountPrivacyDaoImpl AccountPrivacyImpl = new AccountPrivacyDaoImpl();
    public AppPrivacy accountPrivacy(String userid, boolean showedjobs, boolean chats, boolean likejobs){
        boolean showedjobsResult = false;
        boolean chatsResult = false;
        boolean likeResult = false;
        if(showedjobs){
            showedjobsResult = AccountPrivacyImpl.removeShowedJobs(userid);
        }
        if(chats){
            chatsResult = AccountPrivacyImpl.removeChatmessages(userid);
        }
        if(likejobs){
            likeResult =  AccountPrivacyImpl.removeLikejobs(userid);
        }
        AppPrivacy privacy = new AppPrivacy(showedjobsResult,chatsResult,likeResult);
        return privacy;

    }
}
