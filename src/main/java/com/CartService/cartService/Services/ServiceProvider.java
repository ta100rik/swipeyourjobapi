package com.CartService.cartService.Services;

public class ServiceProvider {
    private static final CardService CARD_SERVICE = new CardService();
    public static CardService getCardService(){return CARD_SERVICE;}

}
