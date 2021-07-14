package com.Swipeyourjob.Rest_api.services;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.*;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebJob;
import com.Swipeyourjob.Rest_api.Controllers.WebViews.WebJobList;
import com.Swipeyourjob.Rest_api.Controllers.request.NewJobRequest;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.CompanyDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.JobDaoImpl;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Job;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardImage;
import com.Swipeyourjob.Rest_api.domain.Company.Company;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Joblist;
import com.Swipeyourjob.Rest_api.ResultClass;

import java.util.ArrayList;
import java.util.List;

public class JobService {
    private final JobDaoImpl JobImpl            = new JobDaoImpl();
    private final CompanyDaoImpl CompanyImpl    = new CompanyDaoImpl();

    public AppCard getAppcardByJobid(String jobid,String lon, String lat){
        Job currentcard = JobImpl.getCardByJobid(jobid);
        List<String> images = new ArrayList<>();
//            initiliaze the company info
        AppCompanyinfo companyinfo = new AppCompanyinfo(currentcard.getCompanyname(), currentcard.getCompanyDescription(),currentcard.getCompanyUrl(),currentcard.getOwner(),currentcard.getCompnayLogoUrl());

        AppLocation location       = new AppLocation(currentcard.getLocation().getCity(),currentcard.getLocation().getStreetname(),currentcard.getLocation().getHousenumber(),currentcard.getLocation().getZipcode(),currentcard.getLocation().getJoblongtitude(),currentcard.getLocation().getJoblatitude());
        if(!lon.isEmpty() && !lat.isEmpty()){
            currentcard.getLocation().setJobdistance(lon,lat);
            location.setJobdistance(currentcard.getLocation().getJobdistance());
        }
        AppJobInfo     jobinfo     = new AppJobInfo(currentcard.getJobid(), currentcard.getJobtitle(), currentcard.getDescription(),currentcard.getSalary(),currentcard.getMinHours(),currentcard.getMaxhours());

        for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
            images.add(cardimage.getImageurl());
        }
        AppCard newcard = new AppCard(companyinfo,jobinfo,images,location);
        return newcard;
    }
    public List<AppCard> getAppcardByUserid(String userid, String start, String amount,String lon, String lat){
        Joblist result  = JobImpl.getCardsByUserid(userid,start,amount);
        List<AppCard> cardlist = new ArrayList<>();
        for (Job currentcard : result.getCardList())
        {
            List<String> images = new ArrayList<>();
//            initiliaze the company info
            AppCompanyinfo companyinfo = new AppCompanyinfo(currentcard.getCompanyname(), currentcard.getCompanyDescription(),currentcard.getCompanyUrl(),currentcard.getOwner(),currentcard.getCompnayLogoUrl());

            AppLocation location       = new AppLocation(currentcard.getLocation().getCity(),currentcard.getLocation().getStreetname(),currentcard.getLocation().getHousenumber(),currentcard.getLocation().getZipcode(),currentcard.getLocation().getJoblongtitude(),currentcard.getLocation().getJoblatitude());
            if(!lon.isEmpty() && !lat.isEmpty()){
                currentcard.getLocation().setJobdistance(lon,lat);
                location.setJobdistance(currentcard.getLocation().getJobdistance());
            }

            AppJobInfo     jobinfo     = new AppJobInfo(currentcard.getJobid(), currentcard.getJobtitle(), currentcard.getDescription(),currentcard.getSalary(),currentcard.getMinHours(),currentcard.getMaxhours());

            for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
               images.add(cardimage.getImageurl());
           }
            AppCard newcard = new AppCard(companyinfo,jobinfo,images,location);
            cardlist.add(newcard);
        }
        return cardlist;
    }
    public List<AppCard> getAppBookmarkedCardByUserId(String userid,String lon, String lat){
        Joblist result  = JobImpl.getCardsbyBookmark(userid);
        List<AppCard> cardlist = new ArrayList<>();
        for (Job currentcard : result.getCardList())
        {
            List<String> images = new ArrayList<>();
//            initiliaze the company info
            AppCompanyinfo companyinfo = new AppCompanyinfo(currentcard.getCompanyname(), currentcard.getCompanyDescription(),currentcard.getCompanyUrl(),currentcard.getOwner(),currentcard.getCompnayLogoUrl());

            AppLocation location       = new AppLocation(currentcard.getLocation().getCity(),currentcard.getLocation().getStreetname(),currentcard.getLocation().getHousenumber(),currentcard.getLocation().getZipcode(),currentcard.getLocation().getJoblongtitude(),currentcard.getLocation().getJoblatitude());
            if(!lon.isEmpty() && !lat.isEmpty()){
                currentcard.getLocation().setJobdistance(lon,lat);
                location.setJobdistance(currentcard.getLocation().getJobdistance());
            }

            AppJobInfo     jobinfo     = new AppJobInfo(currentcard.getJobid(), currentcard.getJobtitle(), currentcard.getDescription(),currentcard.getSalary(),currentcard.getMinHours(),currentcard.getMaxhours());

            for (CardImage cardimage : currentcard.getImagelist().getCardImageList()){
                images.add(cardimage.getImageurl());
            }
            AppBookmark bookmark = new AppBookmark(currentcard.getBookmark().getBoomarkid(),currentcard.getBookmark().getBookmarkTimestamp());
            AppCard newcard = new AppCard(companyinfo,jobinfo,images,location,bookmark);
            cardlist.add(newcard);
        }
        return cardlist;
    }

    public int getBookmarkAmountuser(String userid){
        int bookmarkamount = JobImpl.getBookmarkAmountuser(userid);
        return bookmarkamount;
    }
    public ResultClass updateJobStatus(String status,String appuser,int jobid,int webuser){
        ResultClass result = JobImpl.updateJobStatus(status,appuser,jobid,webuser);
        return result;
    }
    public ResultClass newJob(NewJobRequest req, int companyid){
        ResultClass result = JobImpl.newJobHandler(req,companyid);
        return result;
    }


    public ResultClass getWebJobsByUserId(int userid) {
       try{
           ResultClass result = JobImpl.getCardsByCompanyUserid(userid);
           if(result.isOk()){
               Joblist joblist = (Joblist) result.getResult();
               WebJobList webjoblist = new WebJobList();
               for (Job job: joblist.getCardList()){
                   WebJob newWebjob = new WebJob(job.getJobid(),job.getJobtitle(),job.getPeriod().getValiddays(),job.getStringimageList());
                   webjoblist.addJob(newWebjob);
               }
              result =  new ResultClass(webjoblist,200,"ok");
           }
           return result;
       }catch (Exception e){
           ResultClass result =  new ResultClass(null,500,"Sorry could get that");
           return result;
       }
    }

    public ResultClass getLikedJobs(){
        try{
            return null;
        }catch (Exception e){
            ResultClass result = new ResultClass(null,500,"");
            return result;
        }
    }
}
