package com.Swipeyourjob.Rest_api.Controllers.request;

import java.util.ArrayList;
import java.util.List;

public class RoomRequest {
    private String chatname;
    private int chatjobid;
    private String ownerid;
    private List<String> roomGuest = new ArrayList<String>();

    public String getOwnerid() {
        return ownerid;
    }

    public List<String> getRoomGuest() {
        return roomGuest;
    }

    public void setRoomGuest(List<String> roomGuest) {
        this.roomGuest = roomGuest;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
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
}
