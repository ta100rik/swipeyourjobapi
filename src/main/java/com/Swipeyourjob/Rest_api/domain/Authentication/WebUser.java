package com.Swipeyourjob.Rest_api.domain.Authentication;

public class WebUser {
    public int userid;
    public String email;
    public String firstname;
    public String lastname;
    public String role;

    public WebUser(String email,int userid, String roles) {
        this.userid     = userid;
        this.email   = email;
        this.role       = roles;
    }

    public WebUser(int userid, String email, String firstname, String lastname, String role) {
        this.userid = userid;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
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

}
