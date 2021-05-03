package com.Swipeyourjob.Rest_api.Controllers.request;

import java.lang.reflect.Field;

public class CompanyRequest {
    public String companyname;
    public String zipcode;
    public String kvk;
    public String email;
    public String password;
    public String subscribe;
    public String terms;


    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getKvk() {
        return kvk;
    }

    public void setKvk(String kvk) {
        this.kvk = kvk;
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

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public boolean  checkNull() {
        for (Field f : getClass().getFields()) {
            f.setAccessible(true);
            try {
                if (f.get(this) == null) {
                    System.out.println(f);
                    return true;
                }
            } catch (IllegalAccessException e) { // shouldn't happen because I used setAccessible
                return true;
            }
        }
        return false;
    }
}
