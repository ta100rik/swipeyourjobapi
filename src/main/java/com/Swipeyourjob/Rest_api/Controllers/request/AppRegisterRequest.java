package com.Swipeyourjob.Rest_api.Controllers.request;

public class AppRegisterRequest {
    public String firstname;
    public String lastname;
    public String geboortedatum;
    public String email;
    public String password;

    public AppRegisterRequest(String firstname, String lastname, String geboortedatum, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.geboortedatum = geboortedatum;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
