package com.Swipeyourjob.Rest_api.Controllers.WebViews;

import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardImage;

import java.util.ArrayList;
import java.util.List;

public class WebJobList {

    private List<WebJob> joblist = new ArrayList<>();
    public boolean addJob(WebJob job){
        try{
            return this.joblist.add(job);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<WebJob> getJoblist() {
        return joblist;
    }

    public void setJoblist(List<WebJob> joblist) {
        this.joblist = joblist;
    }
}
