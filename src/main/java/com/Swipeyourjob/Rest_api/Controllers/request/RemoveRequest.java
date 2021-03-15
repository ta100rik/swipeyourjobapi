package com.Swipeyourjob.Rest_api.Controllers.request;

public class RemoveRequest {
    private String userid;
    private boolean showedjobs;
    private boolean chats;
    private boolean likejobs;
    private boolean bookmarks;

    public boolean isBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(boolean bookmarks) {
        this.bookmarks = bookmarks;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isShowedjobs() {
        return showedjobs;
    }

    public void setShowedjobs(boolean showedjobs) {
        this.showedjobs = showedjobs;
    }

    public boolean isChats() {
        return chats;
    }

    public void setChats(boolean chats) {
        this.chats = chats;
    }

    public boolean isLikejobs() {
        return likejobs;
    }

    public void setLikejobs(boolean likejobs) {
        this.likejobs = likejobs;
    }
}
