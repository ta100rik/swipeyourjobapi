package com.Swipeyourjob.Rest_api.domain;

import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;

public class Card {
    private int cardid;
    private String cardtitle;
    private String companyname;
    private String companyDescription;
    private String companyUrl;
    private String description;
    private CardImageList imagelist;
    private float salary;
    private int minHours;
    private int maxhours;
    private CardLocation location;
    private String owner;

    public Card(int cardid, String cardTitel, String city, String companyname, CardImageList imagelist, String description, String companyDescription, String companyurl, float salary, int minHours, int maxhours, CardLocation cardlocation , String user) {
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

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    public void setMaxhours(int maxhours) {
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

    public int getMinHours() {
        return minHours;
    }

    public int getMaxhours() {
        return maxhours;
    }

    public CardLocation getLocation() {
        return location;
    }

    public String getOwner() {
        return owner;
    }
}
