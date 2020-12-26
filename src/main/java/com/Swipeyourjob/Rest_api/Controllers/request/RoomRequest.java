package com.Swipeyourjob.Rest_api.Controllers.request;

import java.util.ArrayList;
import java.util.List;

public class RoomRequest {
    private String chatname;
    private int chatjobid;
    private int ownerid;
    private List<Integer> roomGuest = new ArrayList<Integer>();

    public int getOwnerid() {
        return ownerid;
    }

    public List<Integer> getRoomGuest() {
        return roomGuest;
    }

    public void setRoomGuest(List<Integer> roomGuest) {
        this.roomGuest = roomGuest;
    }

    public void setOwnerid(int ownerid) {
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
