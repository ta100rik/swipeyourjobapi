package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.AppViews.AppCard;
import com.CartService.cartService.domain.ListClasses.Cardlist;
import com.CartService.cartService.domain.MatchRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class Appcontroller {

    @PostMapping("/addLike")
    public ResponseEntity<?> Addlike(@RequestBody MatchRequest matchRequest) throws JSONException {
        int result = ServiceProvider.getCardService().newLike(matchRequest.getUserid(),matchRequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(matchRequest);
        }else{
            return ResponseEntity.status(500).body(matchRequest);
        }

    }

    @GetMapping("/cards")
    public ResponseEntity<?> getCards(){
        List<AppCard> result = ServiceProvider.getCardService().getAppCards();
        return ResponseEntity.ok(new Gson().toJson(result));
    }



}
