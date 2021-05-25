package com.Swipeyourjob.Rest_api.Controllers.request;

public class VerificationcodeRequest {
    public String email;
    public int verficationcode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVerficationcode() {
        return verficationcode;
    }

    public void setVerficationcode(int verficationcode) {
        this.verficationcode = verficationcode;
    }
}
