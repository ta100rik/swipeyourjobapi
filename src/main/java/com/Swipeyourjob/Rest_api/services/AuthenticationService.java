package com.Swipeyourjob.Rest_api.services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.MailDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Authentication.Passwordservice;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;
import io.jsonwebtoken.Claims;

public class AuthenticationService {
    Passwordservice passwordService = new Passwordservice();
    IdenticationDaoImpl identicationService = new IdenticationDaoImpl();
    MailDaoImpl mailService = new MailDaoImpl();
    public  WebUser register(String email,String password, int roleid){
        String hashedpassword = this.passwordService.hashpassword(password);
        WebUser newuser = identicationService.registerWebUser(email,hashedpassword,roleid);
        return newuser;
    }
    public String VerifyUser(String email, int verficationcode){
        WebUser verification = identicationService.verifiyUser(email,verficationcode);
        if(verification != null){
            return this.user2jwttoken(verification);
        }else{
            return "False";
        }
    }

    public String user2jwttoken(WebUser user){
        String jwttoken = this.passwordService.generateJWTtoken(user);
        return jwttoken;
    }
    private Boolean checklogin(String email, String password){
        String currentPassword = identicationService.getHashedPassword(email);
        if(!currentPassword.equals("False")) {
            String UserPassword = this.passwordService.hashpassword(password);
            if(UserPassword.equals(currentPassword)){
                return true;
            }
        }
        return false;
    }
    private WebUser getWebuserByEmail(String email){
        return identicationService.getWebuserByEmail(email);
    }
    public String login(String email, String password){
        boolean loggedin = this.checklogin(email,password);
        System.out.println(loggedin);
        if(loggedin){
            WebUser user = this.getWebuserByEmail(email);
            if(user != null){
                String jwttoken = this.passwordService.generateJWTtoken(user);
                return jwttoken;
            }else{
                return "False";
            }
        }else{
            return "False";
        }
    }
    private Claims decode(String jwt){
        Claims claim = this.passwordService.decodeJWT(jwt);
        return claim;
    }
    public String getUserRole(String jwt){
        Claims claim = decode(jwt);
        if(claim == null){
            return null;
        }else{
            String role = (String) claim.get("Role");
            return role;
        }

    }

    public String forgetmail(String email){

        WebUser user = identicationService.getWebuserByEmail(email);

        if(user != null){
            int random_int = (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);
            identicationService.saveForgetPasswordCode(random_int,email);
            mailService.sendForgotPasswordMail(mailService.getsession(),random_int,email,user.getFirstname());
            return "Mail is send";
        }else{
            return "Sorry user does not exist";
        }
    }
    public String ChangePassword(int code,String email, String password){
        WebUser webuser = identicationService.getWebuserByEmail(email);
        if(webuser != null){
            boolean validpasswordcode = identicationService.hasValidForgotcode(email,code);
            if(validpasswordcode){
                String hashedpassword = passwordService.hashpassword(password);
                boolean changedpassword = identicationService.UpdatePassword(webuser,hashedpassword);
                if(changedpassword){
                    String jwttoken = this.passwordService.generateJWTtoken(webuser);
                    return jwttoken;
                }else{
                    return "False";
                }
            }else{
                return "False";
            }
        }else{
            return "False";
        }
    }
    public boolean Sendverificationmail(String mail,int verificationcode,int userid){
        identicationService.saveVerficationcode(verificationcode,userid);

        return mailService.sendVerificationMail(mailService.getsession(),verificationcode,mail);
    }
    public int getUserid(String jwt){
        Claims claim = decode(jwt);
        if(claim == null){
            return 0;
        }else{
            int role = (int) claim.get("userid");
            return role;
        }

    }






}
