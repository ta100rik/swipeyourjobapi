package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.request.getTokenRequest;
import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/validateperson")
    public ResponseEntity<?> getToken(@RequestBody  getTokenRequest gettoken){
        System.out.println(ServiceProvider.getFirebaseService().validateUser("test"));
        System.out.println(ServiceProvider.getFirebaseService().validateUser(gettoken.getUid()));
        return ResponseEntity.ok(ServiceProvider.getFirebaseService().validateUser(gettoken.getUid()));
    }
}
