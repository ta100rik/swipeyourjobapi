package com.CartService.cartService.dataLayer.InterfacesDao;

import com.CartService.cartService.domain.Cardlist;

public interface likeDao {
    int newLike(int userid, int cardid);
    Cardlist getCards();
}
