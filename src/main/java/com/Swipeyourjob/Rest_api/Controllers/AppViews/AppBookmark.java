package com.Swipeyourjob.Rest_api.Controllers.AppViews;

import java.util.Date;

public class AppBookmark {
    private int boomarkid;
    private Date bookmarkTimestamp;

    public AppBookmark(int boomarkid, Date bookmarkTimestamp) {
        this.boomarkid = boomarkid;
        this.bookmarkTimestamp = bookmarkTimestamp;
    }

    public int getBoomarkid() {
        return boomarkid;
    }

    public void setBoomarkid(int boomarkid) {
        this.boomarkid = boomarkid;
    }

    public Date getBookmarkTimestamp() {
        return bookmarkTimestamp;
    }

    public void setBookmarkTimestamp(Date bookmarkTimestamp) {
        this.bookmarkTimestamp = bookmarkTimestamp;
    }
}
