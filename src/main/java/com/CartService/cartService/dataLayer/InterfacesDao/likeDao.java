package com.CartService.cartService.dataLayer.InterfacesDao;

import com.CartService.cartService.domain.ListClasses.Cardlist;

public interface likeDao {
    int newLike(int userid, int cardid);
    Cardlist getCards();
    Cardlist getCardsByUserid(String userid,String start, String amount);
}
