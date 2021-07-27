package com.Swipeyourjob.Rest_api.domain.ListClasses;


import com.Swipeyourjob.Rest_api.domain.Cardsinfo.LikedJob;

import java.util.ArrayList;
import java.util.List;

public class LikedJobsList {
    private List<LikedJob> likedJobList = new ArrayList<>();

    public List<LikedJob> getLikedJobList() {
        return likedJobList;
    }

    public boolean addLikedJob(LikedJob likedjob){
        try{
            return this.likedJobList.add(likedjob);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
