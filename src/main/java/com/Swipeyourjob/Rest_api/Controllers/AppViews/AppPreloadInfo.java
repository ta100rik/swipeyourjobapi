package com.Swipeyourjob.Rest_api.Controllers.AppViews;

public class AppPreloadInfo {
    private int roomsamount;
    private int bookmarksamount;

    public AppPreloadInfo(int roomsamount, int bookmarksamount) {
        this.roomsamount = roomsamount;
        this.bookmarksamount = bookmarksamount;
    }

    public int getRoomsamount() {
        return roomsamount;
    }

    public void setRoomsamount(int roomsamount) {
        this.roomsamount = roomsamount;
    }

    public int getBookmarksamount() {
        return bookmarksamount;
    }

    public void setBookmarksamount(int bookmarksamount) {
        this.bookmarksamount = bookmarksamount;
    }
}
