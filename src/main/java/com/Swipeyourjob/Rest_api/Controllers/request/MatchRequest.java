package com.Swipeyourjob.Rest_api.Controllers.request;

public class MatchRequest {
    private String userid;
    private int cardid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }


    public int getCardid() {
        return cardid;
    }
}
