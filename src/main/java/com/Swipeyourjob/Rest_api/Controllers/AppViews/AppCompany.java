package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppCompany {
    public String title;
    public String description;
    public String webUrl;
    public String companyLogo;

    public AppCompany(String title, String description, String webUrl, String companyLogo) {
        this.title = title;
        this.description = description;
        this.webUrl = webUrl;
        this.companyLogo = companyLogo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
}
