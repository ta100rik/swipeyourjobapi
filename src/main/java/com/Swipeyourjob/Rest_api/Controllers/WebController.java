package com.Swipeyourjob.Rest_api.Controllers;

import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebCompanyProfile;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebImageUrl;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebLoginResponse;
import com.Swipeyourjob.Rest_api.Controllers.request.*;
import com.Swipeyourjob.Rest_api.ResultClass;
import com.Swipeyourjob.Rest_api.domain.Company.Company;
import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/web")
public class WebController {
    
    @PostMapping("/uploadimage")
    public ResponseEntity<?>  uploadImage(@RequestParam("imageFile") MultipartFile file) {
         try{
             String url = ServiceProvider.getHostingService().UploadImage(file);
             WebImageUrl RESULT = new WebImageUrl(url);
             return ResponseEntity.ok(RESULT);
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
                Thread sendmailThread = new Thread(){
                    public void run(){
                        ServiceProvider.getAuthenticationService().Sendverificationmail(companyRequest.getEmail(),random_int,admin.getUserid());
                    }
                };
                sendmailThread.start();
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

            int userid = Integer.parseInt(userinfo[2]);
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
                int userid = Integer.parseInt(userinfo[2]);
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



    @PostMapping("/updateCompanyProfile")
    public ResponseEntity<?> updateProfile(@RequestBody WebCompanyProfile profile){
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");

            int userid = Integer.parseInt(userinfo[2]);
            return ResponseEntity.ok(ServiceProvider.getCompanyService().updateEstablishmentProfile(profile,userid));
        }catch (Exception e){
            System.out.println(e.getMessage());
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
        ResultClass result = null;
        try{
            String email = forgot.getEmail();
            result =  ServiceProvider.getAuthenticationService().forgetmail(email);
        }catch (Exception e){
            result = new ResultClass(null,500,"NOK");
        }
        return ResponseEntity.status(result.getStatuscode()).body(result);
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
        ResultClass RESULT = null;
        // checking if the request is valid
        boolean validrequest = true;
        String reasonstring = "";
        try{

            // checking the request
            if(req.getJobImage() == null){
                validrequest = false;
                reasonstring += "There is no image \n";
            }

            if(req.getSalaryLength() == 0){ // salary need to be defined
                validrequest = false;
                reasonstring += "No salary defined\n";
            }
            // Length check
            if(req.getAvaibilityLength() != 7){ // avaibility need to be 7 items
                validrequest = false;
                reasonstring += "The avaibility need to be a array of 7 items\n";
            }
            if(req.getAvaibilitytimelength() != 28){ // 4 types X 7 days = 28
                validrequest = false;
                reasonstring += "Sorry but you are missing a time zone in 1 of the days";
            }
            if(req.getTagsLength() == 0){
                validrequest = false;
                reasonstring += "No tags defined";
            }

            // Start and Enddate check
            if(req.getStartdate() != null && req.getEnddate() != null){
                if(!req.getStartdate().equals("") && !req.getEnddate().equals("")){
                    Date startdate =new SimpleDateFormat("yyyy-MM-dd").parse(req.getStartdate());
                    Date enddate =new SimpleDateFormat("yyyy-MM-dd").parse(req.getEnddate());
                    if(startdate.after(enddate)){
                        validrequest = false;
                        reasonstring += "Sorry but your startdate is before the enddate";
                    }
                }
            }else if(req.getStartdate() != null){
                LocalDate date = LocalDate.now();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                req.setStartdate(dateFormat.format(date));
            }

            if(!validrequest){
                RESULT = new ResultClass(null,400,reasonstring);
            }
            // TODO: add a database check

            // Result is null this means no error so let start shooting it in to the database
            if(RESULT == null){
                Company companyProfile = ServiceProvider.getCompanyService().getCompanydetailsByEstablishment(req.getEstamblishmentid());

                RESULT = ServiceProvider.getJobService().newJob(req,companyProfile.getCompany_id());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            RESULT = new ResultClass(null,500,"You found a bug please show this to Swipe your job");
        }
        return ResponseEntity.status(RESULT.getStatuscode()).body(RESULT);
    }
    @PostMapping("/updateJobStatus")
    public ResponseEntity<?> updateUserJobStatus(@RequestBody AppJobStatusUpdateRequest jobrequest){
        String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
        int userid = Integer.parseInt(userinfo[2]);

        ResultClass RESULT = new ResultClass(null,500,"Api error");
        try{
            String jobstatus = jobrequest.getStatus().toLowerCase();
            if(jobstatus.equals("rejected") || jobstatus.equals("accepted")){
                RESULT = ServiceProvider.getJobService().updateJobStatus(jobrequest.getStatus(),jobrequest.getUserid(),jobrequest.getJobid(),userid);

            }else{
                RESULT = new ResultClass(null,400,"You not allowed to set this status");
            }
        }catch (Exception e){

            RESULT = new ResultClass(null,500,"Api error");
        }
        System.out.println(RESULT.getReason());
        return ResponseEntity.status(RESULT.getStatuscode()).body(RESULT);

    }
    @GetMapping("/getjobs")
    public ResponseEntity<?> getJobsCompany(){
        ResultClass RESULT = null;
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            int userid = Integer.parseInt(userinfo[2]);
            RESULT = ServiceProvider.getJobService().getWebJobsByUserId(userid);

        }catch (Exception e){
            RESULT = new ResultClass(null,500,"api error");
        }
        return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
    }

    @GetMapping("/getlikes")
    public ResponseEntity<?> getJoblikes(@RequestParam("status") String status){
        if(status.equals("all")){
            status = "\"liked\",\"denied\",\"denied\",\"accepted\",\"removed\"";
        }else{
            String[] options = {"liked","denied","accepted","removed"};
            Set<String> optionsset = new HashSet<String>(Arrays.asList(options));
            String[] filters =  status.split(",");
            status = "";
            int count = 1;
            for (String item: filters){
                if(!optionsset.contains(item)){
                    status = "";
                    break;
                }
                String comma = (count == filters.length)?"":",";
                status += "\""+item+"\"" + comma;
                count++;

            }
        }

        ResultClass RESULT = null;

        try{
            if(!status.equals("")){
                String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
                int userid = Integer.parseInt(userinfo[2]);

                RESULT = ServiceProvider.getJobService().getLikedJobs(userid,status);
            }else{
                RESULT = new ResultClass(null,402,"That filter doesn't seams correct");
            }
            return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
        }catch(Exception e){
            System.out.println(e.getMessage());
            RESULT = new ResultClass(null,500,"api error");
            return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
        }
    }

    @GetMapping("/getlikes/{jobid}")
    public ResponseEntity<?> getJoblikes(@RequestParam("status") String status,
                                         @PathVariable("jobid") int id){
        if(status.equals("all")){
            status = "\"liked\",\"denied\",\"denied\",\"accepted\",\"removed\"";
        }else{
            String[] options = {"liked","denied","accepted","removed"};
            Set<String> optionsset = new HashSet<String>(Arrays.asList(options));
            String[] filters =  status.split(",");
            status = "";
            int count = 1;
            for (String item: filters){
                if(!optionsset.contains(item)){
                    status = "";
                    break;
                }
                String comma = (count == filters.length)?"":",";
                status += "\""+item+"\"" + comma;
                count++;

            }
        }

        ResultClass RESULT = null;
        try{
            if(!status.equals("")){
                String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
                int userid = Integer.parseInt(userinfo[2]);
                RESULT = ServiceProvider.getJobService().getLikedJobs(userid,status,id);
            }else{
                RESULT = new ResultClass(null,402,"That filter doesn't seams correct");
            }
            return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
        }catch(Exception e){
            RESULT = new ResultClass(null,500,"api error");
            return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
        }
    }
    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms(
            @RequestParam(required = true) String start,
            @RequestParam(required = true) String amount
    ){
        ResultClass RESULT = null;
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            String userid = userinfo[2];
            return ResponseEntity.ok(new Gson().toJson(ServiceProvider.getChatService().getPersonalRooms(userid,start,amount)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT.getResult());
    }
    @PostMapping("/createRoom")
    public ResponseEntity<?> AddRoom(@RequestBody RoomRequest roomrequest) throws JSONException {
        ResultClass RESULT = null;
        try{
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            String userid = userinfo[2];
            int roomid = ServiceProvider.getChatService().CreateRoom(roomrequest.getChatjobid(), roomrequest.getChatname(),userid,roomrequest.getRoomGuest());
            if(roomid != 0){
                RESULT = new ResultClass(roomid,200,"Ok");
            }else{
                RESULT = new ResultClass(roomid,402,"not ok room not created");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            RESULT = new ResultClass(null,500,"api error");
        }
        return  ResponseEntity.status(RESULT.getStatuscode()).body(RESULT);
    }

    @GetMapping("/getChatMessages")
    public ResponseEntity<?> getChatHistory(
            @RequestParam(required = true) int roomid ,
            @RequestParam(required = true) String amount
    ){
        try {
            String[] userinfo = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).split("_");
            String userid = userinfo[2];
            return ResponseEntity.ok(new Gson().toJson(ServiceProvider.getChatService().getChatHistoryRoom(roomid, userid, amount)));
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }
}
