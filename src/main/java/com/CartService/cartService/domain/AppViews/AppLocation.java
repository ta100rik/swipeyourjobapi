package com.CartService.cartService.domain.AppViews;

public class AppLocation {
    private String city;
    private String streetname;
    private int housenumber;
    private String zipcode;
    private double distance;
    private double latitude;
    private double longtitude;

    public AppLocation(String city, String streetname, int housenumber, String zipcode, double lon, double lan) {
        this.city = city;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.longtitude = lon;
        this.latitude    = lan;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setJobdistance(double jobdistance) {
        this.distance = jobdistance;
    }

    public String getCity() {
        return city;
    }

    public String getStreetname() {
        return streetname;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public double getJobdistance() {
        return distance;
    }
}
