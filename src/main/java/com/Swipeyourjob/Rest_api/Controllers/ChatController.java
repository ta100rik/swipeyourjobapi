package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.request.MessageRequest;
import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.request.RoomRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chat")
public class ChatController {
    @PostMapping("/createRoom")
    public ResponseEntity<?> AddRoom(@RequestBody RoomRequest roomrequest) throws JSONException {
        int roomid = ServiceProvider.getChatService().CreateRoom(roomrequest.getChatjobid(), roomrequest.getChatname(),roomrequest.getOwnerid(),roomrequest.getRoomGuest());
        return ResponseEntity.ok(new Gson().toJson(roomid));
    }
    @PostMapping("/sendMessage")
    public ResponseEntity<?> SendMessage(@RequestBody MessageRequest messageRequest) throws JSONException {
        try{
            boolean message = ServiceProvider.getChatService().SendMessage(messageRequest.getUserid(),messageRequest.getRoomid(),messageRequest.getMessage());
            return ResponseEntity.ok(message);
        }catch (Exception e){
            boolean message = false;
            return ResponseEntity.ok(message);
        }
    }

    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms(
            @RequestParam(required = true) String userid,
            @RequestParam(required = true) String start,
            @RequestParam(required = true) String amount
    ){
        return ResponseEntity.ok(new Gson().toJson(ServiceProvider.getChatService().getPersonalRooms(userid,start,amount)));
    }


    @GetMapping("/getChatMessages")
    public ResponseEntity<?> getChatHistory(
            @RequestParam(required = true) String userid,
            @RequestParam(required = true) int roomid ,
            @RequestParam(required = true) String amount
    ){
        try {
            return ResponseEntity.ok(new Gson().toJson(ServiceProvider.getChatService().getChatHistoryRoom(roomid, userid, amount)));
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }





}
