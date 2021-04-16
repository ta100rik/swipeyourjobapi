package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppCompany;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebJob;
import com.Swipeyourjob.Rest_api.Controllers.request.CompanyRequest;
import com.Swipeyourjob.Rest_api.Controllers.request.LoginRequest;
import com.Swipeyourjob.Rest_api.Controllers.request.MessageRequest;
import com.Swipeyourjob.Rest_api.Services.ServiceProvider;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppJobInfo;
import com.Swipeyourjob.Rest_api.Controllers.request.CardRequest;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/web")
public class WebController {
    
    @PostMapping("/uploadimage")
    public ResponseEntity<?>  uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        try{

            return ResponseEntity.ok(ServiceProvider.getHostingService().UploadImage(file));
        }catch (Exception e){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
    @PostMapping("/newCompany")
    public ResponseEntity<?> newCompany(@RequestBody CompanyRequest companyRequest){
        /*
        *   Checking if all the information is there
        * */
        if(companyRequest.checkNull()){
            return ResponseEntity.status(500).body("You are missing a value of the required one's");
        }else{
            /*
                * Because we have everything in place now we gonna create the company first and then create a webuser.
            */
            int newcompany = ServiceProvider.getCompanyService().createCompany(companyRequest.getDescription(),companyRequest.getTitle(),companyRequest.getWeburl(),companyRequest.getCompanyLogo());
            if(newcompany != 0){
                String jwttoken = ServiceProvider.getAuthenticationService().register(companyRequest.getUserName(),companyRequest.getPassword(),companyRequest.getFirstname(),companyRequest.getLastname(),2);
                return ResponseEntity.ok(jwttoken);
            }else{
                return ResponseEntity.status(500).body("Company isn't created sorry the information wasn't correct");
            }
        }
    }

    @GetMapping("/getjobs")
    public ResponseEntity<?> getjobs(){
        /*
         *   Checking if all the information is there
         * */
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            System.out.println(userinfo[0]);
            int companyid = Integer.parseInt(userinfo[1]);
            List<WebJob> joblist = ServiceProvider.getCardService().getWebJobsByCompanyid(companyid);
            if(joblist != null){
                return ResponseEntity.ok(new Gson().toJson(joblist));
            }else{
                return ResponseEntity.status(500).body("Web jobs didn't wen't well");
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginrequest ){
        try{
            String username = loginrequest.getUsername();
            String userpassword = loginrequest.getPassword();
            String result = ServiceProvider.getAuthenticationService().login(username,userpassword);
            if(!result.equals("False")){
                return ResponseEntity.ok(result);
            }else{
                return ResponseEntity.status(403).body("Sorry, your username or/and password combination wasn't correct");
            }
        }catch (Exception e){
            return ResponseEntity.status(50).body("Server error");
        }
    }



}
