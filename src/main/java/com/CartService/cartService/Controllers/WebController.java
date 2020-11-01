package com.CartService.cartService.Controllers;

import com.CartService.cartService.Services.ServiceProvider;
import com.CartService.cartService.domain.CardRequest;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web")
public class WebController {

    @PostMapping("/newCard")
    public ResponseEntity<?> Card(@RequestBody CardRequest cardrequest) throws JSONException {
        int result = ServiceProvider.getCardService().newCard(cardrequest.getcardtitle(),cardrequest.getCity(),cardrequest.getCompanyname());
        if(result != 0){
            return ResponseEntity.ok(cardrequest);
        }else{
            return ResponseEntity.status(500).body(cardrequest);
        }
    }





}
