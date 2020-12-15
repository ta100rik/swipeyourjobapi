package com.Swipeyourjob.Rest_api.domain;

public class ChatMessage {
    private String chatmessage;
    private String userid;

    public ChatMessage(String chatmessage, String userid) {
        this.chatmessage = chatmessage;

        this.userid = userid;
    }

    public String getChatmessage() {
        return chatmessage;
    }

    public void setChatmessage(String chatmessage) {
        this.chatmessage = chatmessage;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
