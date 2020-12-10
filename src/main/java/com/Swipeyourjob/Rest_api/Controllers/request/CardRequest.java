package com.Swipeyourjob.Rest_api.Controllers.request;

import java.util.ArrayList;
import java.util.List;

public class CardRequest {
    private String cardtitle;
    private String city;
    private String companyname;
    private String description;
    private List<String> images = new ArrayList<>();

    public String getCardtitle() {
        return cardtitle;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
