package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCard;
import com.Swipeyourjob.Rest_api.Controllers.request.MatchRequest;
import com.Swipeyourjob.Rest_api.Controllers.request.showRequest;
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
    @GetMapping("/cards/{jobid}")
    public ResponseEntity<?> getCardById(
            @PathVariable("jobid") String id,
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
            AppCard result = ServiceProvider.getCardService().getAppcardByJobid(id,lon,lat);
            return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }





}
