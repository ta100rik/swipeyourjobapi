package com.Swipeyourjob.Rest_api.domain;

public class ChatMessage {
    private String chatmessage;
    private String userid;
    private int chatid;
    private String sender;
    public ChatMessage(String chatmessage, String userid,int chatid,String sender) {
        this.chatmessage = chatmessage;
        this.chatid = chatid;
        this.userid = userid;
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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
