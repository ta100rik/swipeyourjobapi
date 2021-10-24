package com.Swipeyourjob.Rest_api.domain.Authentication;

public class AppUser {
    public int appuserid;
    public String firstname;
    public String lastname;
    public String geboortedatum;
    public String email;
    public String rolename;

    public AppUser(int appuserid, String firstname, String lastname, String geboortedatum, String email,String rolename) {
        this.appuserid = appuserid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.geboortedatum = geboortedatum;
        this.email = email;
        this.rolename = rolename;
    }

    public int getAppuserid() {
        return appuserid;
    }

    public void setAppuserid(int appuserid) {
        this.appuserid = appuserid;
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

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
