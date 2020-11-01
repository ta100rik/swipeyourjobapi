package com.CartService.cartService.domain;

import com.CartService.cartService.domain.ListClasses.CardImageList;

public class Card {
    private int cardid;
    private String cardtitle;
    private String city;
    private String companyname;
    private String description;
    private CardImageList imagelist;

    public Card(int cardid, String cardTitel, String city, String companyname, CardImageList imagelist, String description) {
        this.cardid = cardid;
        this.cardtitle = cardTitel;
        this.city = city;
        this.companyname = companyname;
        this.imagelist = imagelist;
        this.description = description;

    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setImagelist(CardImageList imagelist) {
        this.imagelist = imagelist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCardid() {
        return cardid;
    }

    public String getCardTitel() {
        return cardtitle;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyname() {
        return companyname;
    }

    public CardImageList getImagelist() {
        return imagelist;
    }

    public String getCardtitle() {
        return cardtitle;
    }

    public String getDescription() {
        return description;
    }
}
