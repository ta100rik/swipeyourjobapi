package com.Swipeyourjob.Rest_api.Controllers.WebViews;

public class WebLikedJob {
    public String userid;
    public String firstname;
    public String lastname;
    public int age;
    public String[] workexperience;
    public String status;
    public String profileurl;
    public int jobid;
    public String jobname;

    public WebLikedJob(String userid, String firstname, String lastname, int age, String[] workexperience, String status, String profileurl, int jobid, String jobname) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.workexperience = workexperience;
        this.status = status;
        this.profileurl = profileurl;
        this.jobid = jobid;
        this.jobname = jobname;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
