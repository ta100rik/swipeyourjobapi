package com.Swipeyourjob.Rest_api.Controllers.WebViews;

public class WebCompanyProfile {
    public String introduction;
    public String logo;
    public String ownerFirstName;
    public String ownerLastname;
    public String ownerPicture;
    public String weburl;
    public String instagramUrl;
    public String linkedinUrl;
    public String facebookUrl;
    public String place;
    public String streetname;
    public int housenumber;
    public String zipcode;
    public int establishmentid;

    public WebCompanyProfile(String introduction, String logo, String ownerFirstName, String ownerLastname, String ownerPicture, String weburl, String instagramUrl, String linkedinUrl, String facebookUrl, String place, String streetname, int housenumber, String zipcode, int establishmentid) {
        this.introduction = introduction;
        this.logo = logo;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastname = ownerLastname;
        this.ownerPicture = ownerPicture;
        this.weburl = weburl;
        this.instagramUrl = instagramUrl;
        this.linkedinUrl = linkedinUrl;
        this.facebookUrl = facebookUrl;
        this.place = place;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.establishmentid = establishmentid;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public int getEstablishmentid() {
        return establishmentid;
    }

    public void setEstablishmentid(int establishmentid) {
        this.establishmentid = establishmentid;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public String getOwnerPicture() {
        return ownerPicture;
    }

    public void setOwnerPicture(String ownerPicture) {
        this.ownerPicture = ownerPicture;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
