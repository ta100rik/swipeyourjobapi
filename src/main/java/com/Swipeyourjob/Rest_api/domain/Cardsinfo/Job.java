package com.Swipeyourjob.Rest_api.domain.Cardsinfo;

import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private int jobid;
    private String jobtitle;
    private String companyname;
    private String companyDescription;
    private String companyUrl;
    private String companylogo;
    private String description;
    private CardImageList imagelist;
    private float salary;
    private int minHours;
    private int maxhours;
    private CardLocation location;
    private String owner;
    private CardBookmark bookmark;
    private JobPeriod period;
    private int amountlikes;

    public Job(int jobid, String cardTitel, String city, String companyname, CardImageList imagelist, String description, String companyDescription, String companyurl, String compnayLogoUrl, float salary, int minHours, int maxhours, CardLocation cardlocation , String user) {
        this.jobid = jobid;
        this.jobtitle = cardTitel;
        this.companyname        = companyname;
        this.imagelist          = imagelist;
        this.description        = description;
        this.companyDescription = companyDescription;
        this.companyUrl         = companyurl;
        this.maxhours           = maxhours;
        this.minHours           = minHours;
        this.salary             = salary;
        this.location           = cardlocation;
        this.owner              = user;
        this.companylogo = compnayLogoUrl;
    }

    public JobPeriod getPeriod() {
        return period;
    }

    public int getAmountlikes() {
        return amountlikes;
    }

    public void setAmountlikes(int amountlikes) {
        this.amountlikes = amountlikes;
    }

    public void setPeriod(JobPeriod period) {
        this.period = period;
    }

    public CardBookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(CardBookmark bookmark) {
        this.bookmark = bookmark;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }


    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setImagelist(CardImageList imagelist) {
        this.imagelist = imagelist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    public void setMaxhours(int maxhours) {
        this.maxhours = maxhours;
    }

    public void setLocation(CardLocation location) {
        this.location = location;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getJobid() {
        return jobid;
    }

    public String getCardTitel() {
        return jobtitle;
    }


    public String getCompanyname() {
        return companyname;
    }

    public CardImageList getImagelist() {
        return imagelist;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public float getSalary() {
        return salary;
    }

    public int getMinHours() {
        return minHours;
    }

    public int getMaxhours() {
        return maxhours;
    }

    public CardLocation getLocation() {
        return location;
    }

    public String getOwner() {
        return owner;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public List<String> getStringimageList(){
        List<String> stringList = new ArrayList<String>();
        for ( CardImage image : this.getImagelist().getCardImageList()){
            stringList.add(image.getImageurl());
        }
        return stringList;
    }
}
