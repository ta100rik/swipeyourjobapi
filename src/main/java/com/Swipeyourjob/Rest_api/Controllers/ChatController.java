package com.Swipeyourjob.Rest_api.Controllers;

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
    @GetMapping("/rooms")
    public ResponseEntity<?> getCards(
            @RequestParam(required = true) String userid,
            @RequestParam(required = true) String start,
            @RequestParam(required = true) String amount
    ){
        return ResponseEntity.ok(new Gson().toJson(ServiceProvider.getChatService().getPersonalRooms(userid,start,amount)));
    }




}
