package com.CartService.cartService.domain;

public class CardRequest {
    private String cardtitle;
    private String city;
    private String companyname;

    public void setCardtitel(String cardtitel) {
        this.cardtitle = cardtitel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getcardtitle() {
        return cardtitle;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyname() {
        return companyname;
    }
}
