package com.Swipeyourjob.Rest_api.domain;

import java.util.ArrayList;
import java.util.List;

public class chatRoom {
    private int guest_id;
    private String userid;
    private int room_id;
    private int idchat_rooms;
    private String chatname;
    private int chatjobid;
    private String jobTitle;
    private String companyLogo;
    private int roomAdmin;
    private String lastmessage;
    private boolean lastmessageboolean;
    private List<ChatMessage> chatmessages = new ArrayList<ChatMessage>();
    public chatRoom(int guest_id, String userid, int room_id, int idchat_rooms, String chatname, int chatjobid, int roomAdmin,String jobTitle, String companyLogo,String lastmessage,boolean lastmessageread) {
        this.guest_id = guest_id;
        this.userid = userid;
        this.room_id = room_id;
        this.idchat_rooms = idchat_rooms;
        this.chatname = chatname;
        this.chatjobid = chatjobid;
        this.roomAdmin = roomAdmin;
        this.jobTitle = jobTitle;
        this.companyLogo = companyLogo;
        this.lastmessage = lastmessage;
        this.lastmessageboolean = lastmessageread;
    }
    public chatRoom(int room_id){
        this.room_id = room_id;
    }
    public boolean addMessage(ChatMessage chatMessage){
       return chatmessages.add(chatMessage);
    }

    public boolean getLastmessageboolean() {
        return lastmessageboolean;
    }

    public void setLastmessageboolean(boolean lastmessageboolean) {
        this.lastmessageboolean = lastmessageboolean;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLastmessage() {
        return lastmessage;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public void setChatmessages(List<ChatMessage> chatmessages) {
        this.chatmessages = chatmessages;
    }

    public List<ChatMessage> getChatmessages() {
        return chatmessages;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getIdchat_rooms() {
        return idchat_rooms;
    }

    public void setIdchat_rooms(int idchat_rooms) {
        this.idchat_rooms = idchat_rooms;
    }

    public String getChatname() {
        return chatname;
    }

    public void setChatname(String chatname) {
        this.chatname = chatname;
    }

    public int getChatjobid() {
        return chatjobid;
    }

    public void setChatjobid(int chatjobid) {
        this.chatjobid = chatjobid;
    }

    public int getRoomAdmin() {
        return roomAdmin;
    }

    public void setRoomAdmin(int roomAdmin) {
        this.roomAdmin = roomAdmin;
    }
}
