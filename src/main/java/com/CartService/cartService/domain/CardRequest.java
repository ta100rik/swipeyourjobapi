package com.CartService.cartService.domain;

public class CardRequest {
    private String cardtitel;
    private String city;
    private String companyname;

    public void setCardtitel(String cardtitel) {
        this.cardtitel = cardtitel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCardtitel() {
        return cardtitel;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyname() {
        return companyname;
    }
}
