package com.CartService.cartService.domain;

public class Card {
    private int cardid;
    private String cardTitel;
    private String city;
    private String companyname;
    private CardImageList imagelist;

    public Card(int cardid, String cardTitel, String city, String companyname, CardImageList imagelist) {
        this.cardid = cardid;
        this.cardTitel = cardTitel;
        this.city = city;
        this.companyname = companyname;
        this.imagelist = imagelist;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public void setCardTitel(String cardTitel) {
        this.cardTitel = cardTitel;
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

    public int getCardid() {
        return cardid;
    }

    public String getCardTitel() {
        return cardTitel;
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
}
