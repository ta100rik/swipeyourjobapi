package com.Swipeyourjob.Rest_api.Controllers.WebViews;

public class WebLikedJob {
    public String userid;
    public String firstname;
    public String lastname;
    public int leeftijd;
    public String[] workexperience;
    public String status;
    public String profileurl;

    public WebLikedJob(String userid, String firstname, String lastname, int leeftijd, String[] workexperience, String status, String profileurl) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.leeftijd = leeftijd;
        this.workexperience = workexperience;
        this.status = status;
        this.profileurl = profileurl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String[] getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(String[] workexperience) {
        this.workexperience = workexperience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }
}
