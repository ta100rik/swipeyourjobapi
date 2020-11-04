package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.AppViews.AppCard;
import com.CartService.cartService.domain.request.MatchRequest;
import com.CartService.cartService.domain.request.showRequest;
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
    @PostMapping("/addShowed")
    public ResponseEntity<?> addShowed(@RequestBody showRequest showrequest) throws JSONException {
        int result = ServiceProvider.getCardService().newShowed(showrequest.getUserid(),showrequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(showrequest);
        }else{
            return ResponseEntity.status(500).body(showrequest);
        }

    }

    @GetMapping("/cards")
    public ResponseEntity<?> getCards(@RequestParam(required = false) String userid){
        try{
            if(userid == null){
                List<AppCard> result = ServiceProvider.getCardService().getAppCards();
                return ResponseEntity.ok(new Gson().toJson(result));
            }else{
                List<AppCard> result = ServiceProvider.getCardService().getAppcardByUserid(userid);
                return ResponseEntity.ok(new Gson().toJson(result));
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }




}
