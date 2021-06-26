package com.Swipeyourjob.Rest_api.domain.ListClasses;

import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Job;

import java.util.ArrayList;
import java.util.List;

public class Joblist {
    private List<Job> jobList = new ArrayList<>();


    public List<Job> getCardList() {
        return jobList;
    }

    public boolean addCard(Job job){
        try{
            return this.jobList.add(job);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
