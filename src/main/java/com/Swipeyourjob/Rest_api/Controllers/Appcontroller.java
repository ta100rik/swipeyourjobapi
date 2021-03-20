package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPreloadInfo;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppPrivacy;
import com.Swipeyourjob.Rest_api.Controllers.request.*;
import com.Swipeyourjob.Rest_api.Services.FirebaseService;
import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCard;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/app")
public class Appcontroller {

    @PostMapping("/addLike")
    public ResponseEntity<?> Addlike(@RequestBody MatchRequest matchRequest) throws JSONException {
        int result = ServiceProvider.getCardService().newLike(matchRequest.getUserid(),matchRequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body(result);
        }

    }
    @PostMapping("/addBookmark")
    public ResponseEntity<?> addBookmark(@RequestBody MatchRequest bookmarkRequest){
        System.out.println(bookmarkRequest);
        int result = ServiceProvider.getCardService().newBookmark(bookmarkRequest.getUserid(),bookmarkRequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body("sorry not bookmarked because of a server error");
        }
    }
    @PostMapping("/addShowed")
    public ResponseEntity<?> addShowed(@RequestBody showRequest showrequest) throws JSONException {
        int result = ServiceProvider.getCardService().newShowed(showrequest.getUserid(),showrequest.getCardid());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body(result);
        }

    }
    @PostMapping("/addBug")
    public ResponseEntity<?> addBug(@RequestBody bugRequest bugrequest){
        int result = ServiceProvider.getBuggService().newBug(bugrequest.getUserid(),bugrequest.getUsername(),bugrequest.getDescription(),bugrequest.getVersionnumber());
        if(result != 0){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(500).body("database error");
        }
    }

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
            List<AppCard> result = ServiceProvider.getCardService().getAppBookmarkedCardByUserId(userid,lon,lat);
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
           List<AppCard> result = ServiceProvider.getCardService().getAppcardByUserid(userid , start, amount,lon,lat);
           return ResponseEntity.ok(new Gson().toJson(result));
        }catch (Exception e){
            
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/preloadinfo")
    public ResponseEntity<?> getPreloadinfo(  @RequestParam(required = false) String userid ){
        try{
            int roomamount =  ServiceProvider.getChatService().getRoomamountuser(userid);
            int bookmarkamount = ServiceProvider.getCardService().getBookmarkAmountuser(userid);
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
            AppCard result = ServiceProvider.getCardService().getAppcardByJobid(id,lon,lat);
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

    @PostMapping("/removeBookmark")
    public ResponseEntity<?> removeBookmark(@RequestBody RemoveBookmarkRequest removebookmarkrequest){
        boolean Result = ServiceProvider.getCardService().bookmarkAction(removebookmarkrequest.getBookmarkid(),removebookmarkrequest.getJobid(),removebookmarkrequest.isLikeboolean(),removebookmarkrequest.getUserid());
        if(Result){
            return ResponseEntity.ok(Result);
        }else{
            return ResponseEntity.status(500).body("database error");
        }
    }




}
