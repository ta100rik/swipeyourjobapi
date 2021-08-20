package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.request.MessageRequest;
import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.request.RoomRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chat")
public class ChatController {

//    @PostMapping("/sendMessage")
//    public ResponseEntity<?> SendMessage(@RequestBody MessageRequest messageRequest) throws JSONException {
//        try{
//            boolean message = ServiceProvider.getChatService().SendMessage(messageRequest.getUserid(),messageRequest.getRoomid(),messageRequest.getMessage());
//            return ResponseEntity.ok(message);
//        }catch (Exception e){
//            boolean message = false;
//            return ResponseEntity.ok(message);
//        }
//    }




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
