package com.CartService.cartService.domain;

public class CardLocation {
    private String streetname;
    private int housenumber;
    private String city;
    private String zipcode;
    private boolean defaultlocation;
    private int locationid;

    public CardLocation(String streetname, int housenumber, String city, String zipcode, boolean defaultlocation, int locationid) {
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.city = city;
        this.zipcode = zipcode;
        this.defaultlocation = defaultlocation;
        this.locationid = locationid;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setDefaultlocation(boolean defaultlocation) {
        this.defaultlocation = defaultlocation;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public String getStreetname() {
        return streetname;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public boolean isDefaultlocation() {
        return defaultlocation;
    }

    public int getLocationid() {
        return locationid;
    }
}
