package com.CartService.cartService.domain.AppViews;

public class AppCard {
    private AppCompanyinfo company_info;
    private AppJobInfo job_info;

    public AppCard(AppCompanyinfo company_info, AppJobInfo job_info) {
        this.company_info = company_info;
        this.job_info = job_info;
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
}
