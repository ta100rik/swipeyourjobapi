package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

public interface AccountPrivacyDao {
    boolean removeShowedJobs(String userid);
    boolean removeChatmessages(String userid);
    boolean removeLikejobs(String userid);
}
