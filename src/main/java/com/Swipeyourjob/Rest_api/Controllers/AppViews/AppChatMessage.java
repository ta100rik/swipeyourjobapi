package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppChatMessage {
    public  String message;
    public String user;

    public AppChatMessage(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
