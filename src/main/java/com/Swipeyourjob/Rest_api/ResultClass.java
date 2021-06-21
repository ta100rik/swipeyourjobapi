package com.Swipeyourjob.Rest_api;

public class ResultClass {
    public Object Result;
    public int statuscode;
    public String reason;

    public ResultClass(Object Result, int statuscode, String reason) {
        this.Result = Result;
        this.statuscode = statuscode;
        this.reason = reason;
    }

    public Object getResult() {
        return Result;
    }

    public void setResult(Object result) {
        this.Result = result;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public boolean isOk(){
        if(this.statuscode == 200){
            return  true;
        }else{
            return false;
        }
    }
}
