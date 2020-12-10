package com.CartService.cartService.jwt;

public interface TokenService {
    String generateToken(User user);

    UserPrincipal parseToken(String token);
}
