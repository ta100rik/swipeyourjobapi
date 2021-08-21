package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppChatMessage {
    public  String message;
    public String user;
    public boolean me;
    public String sender;

    public AppChatMessage(String message, String user, String sender) {
        this.message = message;
        this.user = user;
        this.sender = sender;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean setMeBoolean(String userid){
        this.me = (this.user.equals(userid));
        return (this.user.equals(userid));
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
