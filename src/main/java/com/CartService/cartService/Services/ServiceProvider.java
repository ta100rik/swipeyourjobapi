package com.CartService.cartService.Services;

public class ServiceProvider {
    private static final LikeService LIKE_SERVICE = new LikeService();
    public static LikeService getLikeService(){return LIKE_SERVICE;}

}
