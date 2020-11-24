package com.CartService.cartService.domain.AppViews;

public class AppCompanyinfo {
    private String name;
    private String description;
    private String weburl;
    private String representive;

    public AppCompanyinfo(String name, String description, String url, String representive) {
        this.name = name;
        this.description = description;
        this.weburl = url;
        this.representive = representive;
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
}
