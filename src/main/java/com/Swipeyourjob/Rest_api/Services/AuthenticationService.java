package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.IdenticationDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Authentication.Passwordservice;
import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;

public class AuthenticationService {
    Passwordservice passwordService = new Passwordservice();
    IdenticationDaoImpl identicationService = new IdenticationDaoImpl();

    public String register(String username,String password,String firstname, String lastname, int companyid){
        String hashedpassword = this.passwordService.hashpassword(password);
        WebUser newuser = identicationService.registerWebUser(username,hashedpassword,firstname,lastname,companyid);
        String jwttoken = this.passwordService.generateJWTtoken(newuser);
        return jwttoken;
    }
    private Boolean checklogin(String username, String password){
        String currentPassword = identicationService.getHashedPassword(username);
        if(!currentPassword.equals("False")) {
            String UserPassword = this.passwordService.hashpassword(password);
            if(UserPassword.equals(currentPassword)){
                return true;
            }
        }
        return false;
    }
    private WebUser getWebuserByUsername(String username){
        return identicationService.getWebuserByUsername(username);
    }
    public String login(String username, String password){
        boolean loggedin = this.checklogin(username,password);
        if(loggedin){
            WebUser user = this.getWebuserByUsername(username);
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
