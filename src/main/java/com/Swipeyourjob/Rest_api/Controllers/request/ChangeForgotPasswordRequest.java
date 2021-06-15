package com.Swipeyourjob.Rest_api.Controllers.request;

public class ChangeForgotPasswordRequest {
    public String password;
    public String email;
    public int code;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
