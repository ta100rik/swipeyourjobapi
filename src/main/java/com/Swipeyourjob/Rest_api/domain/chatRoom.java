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
    private int roomAdmin;
    private List<ChatMessage> chatmessages = new ArrayList<ChatMessage>();
    public chatRoom(int guest_id, String userid, int room_id, int idchat_rooms, String chatname, int chatjobid, int roomAdmin) {
        this.guest_id = guest_id;
        this.userid = userid;
        this.room_id = room_id;
        this.idchat_rooms = idchat_rooms;
        this.chatname = chatname;
        this.chatjobid = chatjobid;
        this.roomAdmin = roomAdmin;
    }
    public chatRoom(int room_id){
        this.room_id = room_id;
    }
    public boolean addMessage(ChatMessage chatMessage){
       return chatmessages.add(chatMessage);
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
