package com.CartService.cartService.domain.request;

import java.util.ArrayList;
import java.util.List;

public class CardRequest {
    private String cardtitle;
    private String city;
    private String companyname;
    private String description;
    private List<String> images = new ArrayList<>();
    public void setCardtitel(String cardtitel) {
        this.cardtitle = cardtitel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getcardtitle() {
        return cardtitle;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCardtitle() {
        return cardtitle;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }
}
