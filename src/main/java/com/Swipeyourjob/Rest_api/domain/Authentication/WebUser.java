package com.Swipeyourjob.Rest_api.domain.Authentication;

public class WebUser {
    public int userid;
    public String username;
    public String firstname;
    public String lastname;
    public int companyid;

    public WebUser(String username, String firstname, String lastname, int companyid,int userid) {
        this.userid     = userid;
        this.username   = username;
        this.firstname  = firstname;
        this.lastname   = lastname;
        this.companyid  = companyid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }
}
