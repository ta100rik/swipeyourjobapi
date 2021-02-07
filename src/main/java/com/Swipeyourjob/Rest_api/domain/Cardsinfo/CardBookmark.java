package com.Swipeyourjob.Rest_api.domain.Cardsinfo;

import java.util.Date;

public class CardBookmark {
    private int boomarkid;
    private Date bookmarkTimestamp;

    public CardBookmark(int boomarkid, Date bookmarkTimestamp) {
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
