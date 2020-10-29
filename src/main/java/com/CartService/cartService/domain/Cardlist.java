package com.CartService.cartService.domain;

import java.util.ArrayList;
import java.util.List;

public class Cardlist {
    private List<Card> cardList = new ArrayList<>();


    public List<Card> getCardList() {
        return cardList;
    }

    public boolean addCard(Card card){
        try{
            return this.cardList.add(card);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
