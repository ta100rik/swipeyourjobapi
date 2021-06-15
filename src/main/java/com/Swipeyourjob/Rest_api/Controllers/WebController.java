package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebCompanyProfile;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebJob;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebLoginResponse;
import com.Swipeyourjob.Rest_api.Controllers.request.*;
import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/web")
public class WebController {
    
    @PostMapping("/uploadimage")
    public ResponseEntity<?>  uploadImage(@RequestParam("imageFile") MultipartFile file) {
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
        try {
            companyRequest.checkValid();
            if (companyRequest.checkNull()) {
                return ResponseEntity.status(400).body("You are missing a value of the required one's");
            } else {
                /*
                 * Because we have everything in place now we gonna create the company first and then create a webuser.
                 */
                int companyid = ServiceProvider.getCompanyService().createcompany(companyRequest.getCompanyname(), companyRequest.getKvk());
                if (companyid == -1) {throw new HandledException(200, "Error within sql");}
                if (companyid == 0) {throw new HandledException(200, "Kvk is already taken");}
                WebUser admin = ServiceProvider.getAuthenticationService().register(companyRequest.getEmail(),companyRequest.getPassword(),4);
                int estamblishmentid = ServiceProvider.getCompanyService().createEstamblishment(companyid,admin.getUserid(),"HQ",companyRequest.getZipcode(),1);
                if(estamblishmentid == 0){throw new HandledException(401,"Your company is created but the estamblishment isn't");}
                if(estamblishmentid == -2){throw new HandledException(401,"Your company is created and estamblishment but the owner is not assigned");}
                WebLoginResponse RESPONSE = new WebLoginResponse("Check mail", "ok");
                int random_int = (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);
                ServiceProvider.getAuthenticationService().Sendverificationmail(companyRequest.getEmail(),random_int,admin.getUserid());
                return ResponseEntity.ok(RESPONSE);
            }
        }catch (HandledException f){
            return ResponseEntity.status(f.getCode()).body(f.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body("Undefined error");
        }
    }

    @GetMapping("/getEstablishmentProfile")
    public ResponseEntity<?> getUserEstamblishments(){
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            int userid = Integer.parseInt(userinfo[1]);
            return ResponseEntity.ok(ServiceProvider.getCompanyService().userEstablishments(userid));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/getEstablishmentProfile/{establishmentid}")
    public ResponseEntity<?> getEstablishmentprofile(@PathVariable("establishmentid") String estamblishmentid){
        try {
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");

            if(estamblishmentid != null){
                int userid = Integer.parseInt(userinfo[1]);
                int estamblishmentidconv = Integer.parseInt(estamblishmentid);
                boolean hasaccess = ServiceProvider.getCompanyService().hasEstablishmentAccess(userid,estamblishmentidconv);
                if(hasaccess){
                    WebCompanyProfile profile = ServiceProvider.getCompanyService().getCompanyProfile(estamblishmentidconv);
                    return ResponseEntity.ok(profile);
                }else{
                    return ResponseEntity.ok(hasaccess);
                }
            }else{
                throw new HandledException(200,"Estamblishmentid not filled");
            }
        }catch (HandledException f){
            return ResponseEntity.status(f.getCode()).body(f.getMessage());

        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/getjobs")
    public ResponseEntity<?> getjobs(){
        /*
         *   Checking if all the information is there
         * */
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            int userid = Integer.parseInt(userinfo[1]);
            List<WebJob> joblist = ServiceProvider.getCardService().getWebJobsByCompanyid(userid);
            if(joblist != null){
                return ResponseEntity.ok(new Gson().toJson(joblist));
            }else{
                return ResponseEntity.status(500).body("Web jobs didn't wen't well");
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/updateCompanyProfile")
    public ResponseEntity<?> updateProfile(@RequestBody WebCompanyProfile profile){
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            int userid = Integer.parseInt(userinfo[1]);
            return ResponseEntity.ok(ServiceProvider.getCompanyService().updateEstablishmentProfile(profile,userid));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }

    }
    @PostMapping("/verifcationcodeLogin")
    public ResponseEntity<?> LoginVerification(@RequestBody VerificationcodeRequest logininfo){
        String uservaldiation = ServiceProvider.getAuthenticationService().VerifyUser(logininfo.getEmail(),logininfo.getVerficationcode());
        if(!uservaldiation.equals("False")){
            WebLoginResponse RESPONSE = new WebLoginResponse(uservaldiation,"ok");
            return ResponseEntity.ok(RESPONSE);
        }else{
            WebLoginResponse RESPONSE = new WebLoginResponse("Verification code expired or not valid","nok");
            return ResponseEntity.status(402).body(RESPONSE);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginrequest ){
        try{
            String email = loginrequest.getEmail();
            String userpassword = loginrequest.getPassword();

            String result = ServiceProvider.getAuthenticationService().login(email,userpassword);
            if(!result.equals("False")){
                WebLoginResponse RESPONSE = new WebLoginResponse(result,"ok");
                return ResponseEntity.ok(RESPONSE);
            }else{
                WebLoginResponse RESPONSE = new WebLoginResponse("","Username or/and password combination wasn't correct");
                return ResponseEntity.status(403).body(RESPONSE);
            }
        }catch (Exception e){
            return ResponseEntity.status(50).body("Server error");
        }
    }
    @PostMapping("/forgotpassword")
    public ResponseEntity<?> forgotpassword(@RequestBody ForgetpaswordRequest forgot){
        try{
            String email = forgot.getEmail();
            return ResponseEntity.ok(ServiceProvider.getAuthenticationService().forgetmail(email));

        }catch (Exception e){
            return ResponseEntity.status(500).body("Server error");
        }

    }
    @PostMapping("/resetPassword")
    public ResponseEntity<?> ResetPassword(@RequestBody ChangeForgotPasswordRequest passwordrequest){
        String resetpass = ServiceProvider.getAuthenticationService().ChangePassword(passwordrequest.getCode(),passwordrequest.getEmail(),passwordrequest.getPassword());
        if(!resetpass.equals("False")){
            WebLoginResponse RESPONSE = new WebLoginResponse(resetpass,"200");
            return ResponseEntity.ok(RESPONSE);
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/newjob")
    public ResponseEntity<?> newjob(@RequestBody NewJobRequest req){
        String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");

        return ResponseEntity.ok(req);

    }


}
