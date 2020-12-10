package com.Swipeyourjob.Rest_api.domain;

public class CardLocation {
    private String streetname;
    private int housenumber;
    private String city;
    private String zipcode;
    private boolean defaultlocation;
    private int locationid;
    private double joblatitude;
    private double joblongtitude;
    private double jobdistance;

    public CardLocation(String streetname, int housenumber, String city, String zipcode, boolean defaultlocation, int locationid,double joblatitude, double joblongtitude) {
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.city = city;
        this.zipcode = zipcode;
        this.defaultlocation = defaultlocation;
        this.locationid = locationid;
        this.joblatitude = joblatitude;
        this.joblongtitude = joblongtitude;
    }

    public double getJoblatitude() {
        return joblatitude;
    }

    public void setJoblatitude(float joblatitude) {
        this.joblatitude = joblatitude;
    }

    public double getJoblongtitude() {
        return joblongtitude;
    }

    public void setJoblongtitude(float joblongtitude) {
        this.joblongtitude = joblongtitude;
    }

    public double getJobdistance() {
        return jobdistance;
    }

    public void setJobdistance(String lat, String lon) {
        double lonconverted = Double.parseDouble(lon);
        double latconveted  = Double.parseDouble(lat);
        double distance =  distanceCalculator(lonconverted,latconveted,this.joblatitude,this.joblongtitude);
        System.out.println(distance);
        this.jobdistance = distance;
    }
    static double distanceCalculator(double lat1, double lon1,
                            double lat2, double lon2)
    {

        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
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
