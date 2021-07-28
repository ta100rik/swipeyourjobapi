package com.Swipeyourjob.Rest_api.Controllers.WebViews;

import java.util.List;

public class WebJob {
    public int jobid;
    public String jobName;
    public int daysValid;
    public String status;
    public int amountofreactions;
    public List<String> images;

    public WebJob(int jobid, String jobName, int daysValid, List<String> images,String status,int likesamount) {
        this.jobid = jobid;
        this.jobName = jobName;
        this.daysValid = daysValid;
        this.images = images;
        this.status = status;
        this.amountofreactions = likesamount;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getDaysValid() {
        return daysValid;
    }

    public void setDaysValid(int daysValid) {
        this.daysValid = daysValid;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
