package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.request.CardRequest;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/web")
public class WebController {

    @PostMapping("/newCard")
    public ResponseEntity<?> Card(@RequestBody CardRequest cardrequest) throws JSONException {
        System.out.println(cardrequest.getCardtitle());
        System.out.println(cardrequest.getCity());

        System.out.println(cardrequest.getDescription());

        System.out.println(cardrequest.getCompanyname());

        System.out.println(cardrequest.getImages());

        int result = ServiceProvider.getCardService().newCard(cardrequest.getCardtitle(),cardrequest.getCity(),cardrequest.getCompanyname(),cardrequest.getDescription(),cardrequest.getImages());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }





}
