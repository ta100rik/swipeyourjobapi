package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppJobInfo;
import com.Swipeyourjob.Rest_api.Controllers.request.CardRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/companycards")
    public ResponseEntity<?> getCards(@RequestParam(required = false) String companyname){
        try{
            List<AppJobInfo> result = ServiceProvider.getCardService().getAppCards();
            return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }





}
