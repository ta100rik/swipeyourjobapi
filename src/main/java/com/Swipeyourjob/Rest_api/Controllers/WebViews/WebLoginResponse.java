package com.Swipeyourjob.Rest_api.Controllers.WebViews;

public class WebLoginResponse {
    public String token;
    public String status;
    public WebLoginResponse(String jwt, String statuscode){
        this.token = jwt;
        this.status = statuscode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
