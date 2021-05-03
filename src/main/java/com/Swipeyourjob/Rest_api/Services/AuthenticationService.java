package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Authentication.Passwordservice;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;
import io.jsonwebtoken.Claims;

public class AuthenticationService {
    Passwordservice passwordService = new Passwordservice();
    IdenticationDaoImpl identicationService = new IdenticationDaoImpl();

    public  WebUser register(String email,String password, int roleid){
        String hashedpassword = this.passwordService.hashpassword(password);
        WebUser newuser = identicationService.registerWebUser(email,hashedpassword,roleid);
        return newuser;
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

    public int getCompanyid(String jwt){
        Claims claim = decode(jwt);
        if(claim == null){
            return 0;
        }else{
            int role = (int) claim.get("Companyid");
            return role;
        }

    }





}
