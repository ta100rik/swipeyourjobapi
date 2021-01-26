package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppPrivacy {
    private boolean showedjobs;
    private boolean chats;
    private boolean likejobs;

    public AppPrivacy(boolean showedjobs, boolean chats, boolean likejobs) {
        this.showedjobs = showedjobs;
        this.chats = chats;
        this.likejobs = likejobs;
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
