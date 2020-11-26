package com.CartService.cartService.domain;

import com.CartService.cartService.domain.ListClasses.CardImageList;

public class Card {
    private int cardid;
    private String cardtitle;
    private String companyname;
    private String companyDescription;
    private String companyUrl;
    private String description;
    private CardImageList imagelist;
    private float salary;
    private float minHours;
    private float maxhours;
    private CardLocation location;
    private String owner;

    public Card(int cardid, String cardTitel, String city, String companyname, CardImageList imagelist, String description,String companyDescription, String companyurl, float salary, float minHours, float maxhours, CardLocation cardlocation , String user) {
        this.cardid             = cardid;
        this.cardtitle          = cardTitel;
        this.companyname        = companyname;
        this.imagelist          = imagelist;
        this.description        = description;
        this.companyDescription = companyDescription;
        this.companyUrl         = companyurl;
        this.maxhours           = maxhours;
        this.minHours           = minHours;
        this.salary             = salary;
        this.location           = cardlocation;
        this.owner              = user;
    }


    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }


    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setImagelist(CardImageList imagelist) {
        this.imagelist = imagelist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setMinHours(float minHours) {
        this.minHours = minHours;
    }

    public void setMaxhours(float maxhours) {
        this.maxhours = maxhours;
    }

    public void setLocation(CardLocation location) {
        this.location = location;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCardid() {
        return cardid;
    }

    public String getCardTitel() {
        return cardtitle;
    }


    public String getCompanyname() {
        return companyname;
    }

    public CardImageList getImagelist() {
        return imagelist;
    }

    public String getCardtitle() {
        return cardtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public float getSalary() {
        return salary;
    }

    public float getMinHours() {
        return minHours;
    }

    public float getMaxhours() {
        return maxhours;
    }

    public CardLocation getLocation() {
        return location;
    }

    public String getOwner() {
        return owner;
    }
}
