package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.JWTTokenService;
import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.AppViews.AppCard;
import com.CartService.cartService.domain.AppViews.AppJobInfo;
import com.CartService.cartService.domain.request.MatchRequest;
import com.CartService.cartService.domain.request.showRequest;
import com.CartService.cartService.jwt.User;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addShowed(@RequestBody showRequest showrequest) throws JSONException {
        int result = ServiceProvider.getCardService().newShowed(showrequest.getUserid(),showrequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(showrequest);
        }else{
            return ResponseEntity.status(500).body(showrequest);
        }

    }

    @GetMapping("/cards")
    public ResponseEntity<?> getCards(
            @RequestParam(required = true) String userid,
            @RequestParam(required = true) String start,
            @RequestParam(required = true) String amount,
            @RequestParam(required = false) String lon ,
            @RequestParam(required = false) String lat
        ){
        try{
            if(lon == null){
                lon = "";
            }
            if(lat == null){
                lat = "";
            }
           List<AppCard> result = ServiceProvider.getCardService().getAppcardByUserid(userid , start, amount,lon,lat);
           return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/jwttoken")
    public ResponseEntity<?> givetoken(){
        try{
            User user = new User(1,"test","test",true);
            JWTTokenService jwt = new JWTTokenService();
            String token = jwt.generateToken(user);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }



}
