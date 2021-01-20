package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.BuggDaoImpl;

public class BuggService {
    private final BuggDaoImpl BuggImpl = new BuggDaoImpl();
    public int newBug(String userid,String username, String description, String versionnumber){
        int RESULT = BuggImpl.newBug(userid,username,description,versionnumber);
        return RESULT;
    }


}
