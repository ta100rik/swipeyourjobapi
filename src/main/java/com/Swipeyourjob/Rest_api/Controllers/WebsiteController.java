package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.request.ContactForm;
import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/website")
public class WebsiteController {
    @PostMapping("/contact")
    public ResponseEntity<?> contact(ContactForm contactForm){
        String desc = contactForm.getDesc();
        String email = contactForm.getEmail();
        return ResponseEntity.ok(ServiceProvider.getWebsiteService().newContact(email,desc));
    }
}

