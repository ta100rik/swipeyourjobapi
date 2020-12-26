package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppRoom {
    private int room_id;
    private String chatname;
    private int chatjobid;
    private int roomAdmin;
    private String jobLogo;
    private String jobTitle;

    public AppRoom(int room_id, String chatname, int chatjobid, int roomAdmin,String joblogo,String jobtitle) {
        this.room_id = room_id;
        this.chatname = chatname;
        this.chatjobid = chatjobid;
        this.roomAdmin = roomAdmin;
        this.jobLogo = joblogo;
        this.jobTitle = jobtitle;
    }

    public String getJobLogo() {
        return jobLogo;
    }

    public void setJobLogo(String jobLogo) {
        this.jobLogo = jobLogo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
