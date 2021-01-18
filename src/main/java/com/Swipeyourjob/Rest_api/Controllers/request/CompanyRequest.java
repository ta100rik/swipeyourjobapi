package com.Swipeyourjob.Rest_api.Controllers.request;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class CompanyRequest {
    public String Title;
    public String Description;
    public String Weburl;
    public String companyLogo;
    public String lastname;
    public String streetname;
    public String housenumber;
    public String city;
    public String zipcode;
    public String userName;
    public String password;
    public String firstname;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWeburl() {
        return Weburl;
    }

    public void setWeburl(String weburl) {
        Weburl = weburl;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public boolean  checkNull() {
        for (Field f : getClass().getFields()) {
            f.setAccessible(true);
            try {
                if (f.get(this) == null) {

                  return true;
                }
            } catch (IllegalAccessException e) { // shouldn't happen because I used setAccessible
                return true;
            }
        }
        return false;
    }

}
