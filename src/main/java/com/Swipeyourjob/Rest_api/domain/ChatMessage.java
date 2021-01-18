package com.Swipeyourjob.Rest_api.domain;

public class ChatMessage {
    private String chatmessage;
    private String userid;
    private int chatid;
    public ChatMessage(String chatmessage, String userid,int chatid) {
        this.chatmessage = chatmessage;
        this.chatid = chatid;
        this.userid = userid;
    }

    public String getChatmessage() {
        return chatmessage;
    }

    public void setChatmessage(String chatmessage) {
        this.chatmessage = chatmessage;
    }

    public int getChatid() {
        return chatid;
    }

    public void setChatid(int chatid) {
        this.chatid = chatid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
