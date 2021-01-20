package com.Swipeyourjob.Rest_api.Controllers.request;

public class bugRequest {
    private String userid;
    private String username;
    private String description;
    private String versionnumber;

    public bugRequest(String userid, String username, String description, String versionnumber) {
        this.userid = userid;
        this.username = username;
        this.description = description;
        this.versionnumber = versionnumber;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(String versionnumber) {
        this.versionnumber = versionnumber;
    }
}
