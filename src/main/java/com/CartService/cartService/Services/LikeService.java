package com.CartService.cartService.Services;

import com.CartService.cartService.dataLayer.DataAccessObjectsMySQL.DaoImpl.LikeDaoimpl;
import com.CartService.cartService.domain.Cardlist;

public class LikeService {
    private final LikeDaoimpl LikeImpl = new LikeDaoimpl();
    public int newLike(int userid, int cardid){
        return LikeImpl.newLike(userid,cardid);
    }
    public Cardlist getCards(){return LikeImpl.getCards();}
}
