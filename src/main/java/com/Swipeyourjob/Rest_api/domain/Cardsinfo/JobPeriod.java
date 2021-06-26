package com.Swipeyourjob.Rest_api.domain.Cardsinfo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JobPeriod {
    public Date startdate;
    public Date enddate = null;

    public JobPeriod(Date startdate, Date enddate) {
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public int getValiddays(){
        if(this.enddate != null){
           if(this.enddate.compareTo(this.startdate) == 1){
               Date currentDate = new Date();
               long difference = enddate.getTime() - currentDate.getTime();
               int daysBetween = (int) (difference / (1000*60*60*24));
               return daysBetween;
           }else{
               return -2;
           }
        }else{
            return -1;
        }
    }
}
