package com.Swipeyourjob.Rest_api.dataLayer.ResponseClasses;

public class Locationiq {
    public String place_id;
    public String lat;
    public String lon;
    public String display_name;
    public String error;

    public Locationiq(String place_id, String lat, String lon, String display_name, String error) {
        this.place_id = place_id;
        this.lat = lat;
        this.lon = lon;
        this.display_name = display_name;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
