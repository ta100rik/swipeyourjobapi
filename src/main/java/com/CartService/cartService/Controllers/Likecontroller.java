package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.Cardlist;
import com.CartService.cartService.domain.LikeRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Likecontroller {

    @PostMapping("/addLike")
    public ResponseEntity<?> addShoppingcartItem(@RequestBody LikeRequest likerequest) throws JSONException {
        int result = ServiceProvider.getLikeService().newLike(likerequest.getUserid(),likerequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(likerequest);
        }else{
            return ResponseEntity.status(500).body(likerequest);
        }

    }

    @GetMapping("/cards")
    public ResponseEntity<?> getCards(){
        Cardlist result = ServiceProvider.getLikeService().getCards();
        return ResponseEntity.ok(new Gson().toJson(result));
    }



}
