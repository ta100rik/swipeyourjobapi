package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPreloadInfo;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPrivacy;
import com.Swipeyourjob.Rest_api.Controllers.request.*;
import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCard;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class Appcontroller {
    @PostMapping("/addBug")
    public ResponseEntity<?> addBug(@RequestBody bugRequest bugrequest){
        int result = ServiceProvider.getBuggService().newBug(bugrequest.getUserid(),bugrequest.getUsername(),bugrequest.getDescription(),bugrequest.getVersionnumber());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body("database error");
        }
    }
    @PostMapping("/updateJob")

    @GetMapping("/getbookmarks")
    public ResponseEntity<?> getBookmarks(
            @RequestParam(required = true) String userid,
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
            List<AppCard> result = ServiceProvider.getJobService().getAppBookmarkedCardByUserId(userid,lon,lat);
            return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
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
           List<AppCard> result = ServiceProvider.getJobService().getAppcardByUserid(userid , start, amount,lon,lat);
           return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/preloadinfo")
    public ResponseEntity<?> getPreloadinfo(  @RequestParam(required = false) String userid ){
        try{
            int roomamount =  ServiceProvider.getChatService().getRoomamountuser(userid);
            int bookmarkamount = ServiceProvider.getJobService().getBookmarkAmountuser(userid);
            AppPreloadInfo appView = new AppPreloadInfo(roomamount,bookmarkamount);
            return ResponseEntity.ok(appView);
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
            AppCard result = ServiceProvider.getJobService().getAppcardByJobid(id,lon,lat);
            return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/removeData")
    public ResponseEntity<?> removeData(@RequestBody RemoveRequest removerequest){
        AppPrivacy result = ServiceProvider.getAccountPrivacyService().accountPrivacy(removerequest.getUserid(),removerequest.isShowedjobs(),removerequest.isChats(),removerequest.isLikejobs(),removerequest.isBookmarks());
        if(result != null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body("database error");
        }
    }





}
