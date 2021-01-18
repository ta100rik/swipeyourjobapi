package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppPreloadInfo {
    private int roomsamount;

    public AppPreloadInfo(int roomsamount) {
        this.roomsamount = roomsamount;
    }

    public int getRoomsamount() {
        return roomsamount;
    }

    public void setRoomsamount(int roomsamount) {
        this.roomsamount = roomsamount;
    }
}
