package com.Swipeyourjob.Rest_api.Controllers.request;

public class RemoveBookmarkRequest {
    private int jobid;
    private int bookmarkid;
    private boolean likeboolean;
    private String userid;
    public int getJobid() {
        return jobid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getBookmarkid() {
        return bookmarkid;
    }

    public void setBookmarkid(int bookmarkid) {
        this.bookmarkid = bookmarkid;
    }

    public boolean isLikeboolean() {
        return likeboolean;
    }

    public void setLikeboolean(boolean likeboolean) {
        this.likeboolean = likeboolean;
    }
}
