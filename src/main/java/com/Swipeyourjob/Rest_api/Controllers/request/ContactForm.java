package com.Swipeyourjob.Rest_api.Controllers.request;

public class ContactForm {
    public String email;
    public String desc;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
