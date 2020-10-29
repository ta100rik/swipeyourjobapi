package com.CartService.cartService.domain;

public class CardImage {
    private int cardimageid;
    private String imageurl;
    private int cardid;

    public CardImage(int cardimageid, String imageurl, int cardid) {
        this.cardimageid = cardimageid;
        this.imageurl = imageurl;
        this.cardid = cardid;
    }

    public void setCardimageid(int cardimageid) {
        this.cardimageid = cardimageid;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public int getCardimageid() {
        return cardimageid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public int getCardid() {
        return cardid;
    }
}
