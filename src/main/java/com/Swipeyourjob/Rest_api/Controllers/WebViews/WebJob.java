package com.Swipeyourjob.Rest_api.Controllers.WebViews;


import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppLocation;

import java.util.ArrayList;
import java.util.List;

public class WebJob {
    private WebJobInfo job_info;
    private WebJobLocation job_location;
    private List<String> job_images = new ArrayList<>();

    public WebJob(WebJobInfo job_info, WebJobLocation job_location, List<String> job_images) {
        this.job_info = job_info;
        this.job_location = job_location;
        this.job_images = job_images;
    }

    public WebJobInfo getJob_info() {
        return job_info;
    }

    public void setJob_info(WebJobInfo job_info) {
        this.job_info = job_info;
    }

    public WebJobLocation getJob_location() {
        return job_location;
    }

    public void setJob_location(WebJobLocation job_location) {
        this.job_location = job_location;
    }

    public List<String> getJob_images() {
        return job_images;
    }

    public void setJob_images(List<String> job_images) {
        this.job_images = job_images;
    }
}


