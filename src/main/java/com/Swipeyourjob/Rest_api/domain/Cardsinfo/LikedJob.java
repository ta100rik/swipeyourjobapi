package com.Swipeyourjob.Rest_api.domain.Cardsinfo;

import java.util.Date;

public class LikedJob {
    public String userid;
    public String status;
    public Date birthday;

    public LikedJob(String userid, String status) {
        this.userid = userid;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getage(){
        Date today = new Date();
        long difference_In_Time = today.getTime() - this.birthday.getTime();
        int difference_In_Days = Integer.parseInt (String.valueOf((difference_In_Time / (1000 * 60 * 60 * 24)) % 365));
        return difference_In_Days;
    }
}
