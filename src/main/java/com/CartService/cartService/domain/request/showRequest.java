package com.CartService.cartService.domain.request;

public class showRequest {
    private int cardid;
    private String userid;

    public int getCardid() {
        return cardid;
    }

    public String getUserid() {
        return userid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
