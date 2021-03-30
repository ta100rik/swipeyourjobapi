package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppCompanyinfo {
    private String name;
    private String description;
    private String weburl;
    private String representive;
    private String logo;

    public AppCompanyinfo(String name, String description, String url, String representive, String logo) {
        this.name = name;
        this.description = description;
        this.weburl = url;
        this.representive = representive;
        this.logo = logo;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getLogo() {
        return logo;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return weburl;
    }

    public String getRepresentive() {
        return representive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.weburl = url;
    }

    public void setRepresentive(String representive) {
        this.representive = representive;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

}
