package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppRoom {
    private int room_id;
    private String chatname;
    private int chatjobid;
    private int roomAdmin;

    public AppRoom(int room_id, String chatname, int chatjobid, int roomAdmin) {
        this.room_id = room_id;
        this.chatname = chatname;
        this.chatjobid = chatjobid;
        this.roomAdmin = roomAdmin;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
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
