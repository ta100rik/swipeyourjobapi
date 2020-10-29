package com.CartService.cartService.domain;

public class LikeRequest {
    private int userid;
    private int cardid;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public int getUserid() {
        return userid;
    }

    public int getCardid() {
        return cardid;
    }
}
