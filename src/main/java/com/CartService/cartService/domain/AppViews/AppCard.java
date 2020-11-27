package com.CartService.cartService.domain.AppViews;

import java.util.ArrayList;
import java.util.List;

public class AppCard {
    private AppCompanyinfo company_info;
    private AppJobInfo job_info;
    private AppLocation job_location;
    private List<String> job_images = new ArrayList<>();

    public AppCard(AppCompanyinfo company_info, AppJobInfo job_info, List<String> job_images, AppLocation job_location) {
        this.company_info = company_info;
        this.job_info = job_info;
        this.job_location = job_location;
        this.job_images = job_images;
    }

    public AppCompanyinfo getCompany_info() {
        return company_info;
    }

    public void setCompany_info(AppCompanyinfo company_info) {
        this.company_info = company_info;
    }

    public AppJobInfo getJob_info() {
        return job_info;
    }

    public void setJob_info(AppJobInfo job_info) {
        this.job_info = job_info;
    }

    public List<String> getJob_images() {
        return job_images;
    }

    public void setJob_images(List<String> job_images) {
        this.job_images = job_images;
    }

    public AppLocation getJob_location() {
        return job_location;
    }

    public void setJob_location(AppLocation job_location) {
        this.job_location = job_location;
    }
}
