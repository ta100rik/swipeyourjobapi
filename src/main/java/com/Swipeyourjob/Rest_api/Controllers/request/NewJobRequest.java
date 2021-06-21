package com.Swipeyourjob.Rest_api.Controllers.request;

import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Availbility;
import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Salary;

import java.lang.reflect.Field;
import java.util.List;

public class NewJobRequest {
    public int estamblishmentid;
    public String jobName;
    public String jobDescription;
    public String JobImage;
    public String startdate;
    public String enddate;
    public List<Availbility> avaibility;
    public List<String> tags;
    public List<Salary> salary;

    public int getEstamblishmentid() {
        return estamblishmentid;
    }

    public void setEstamblishmentid(int estamblishmentid) {
        this.estamblishmentid = estamblishmentid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobImage() {
        return JobImage;
    }

    public void setJobImage(String jobImage) {
        JobImage = jobImage;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public List<Availbility> getAvaibility() {
        return avaibility;
    }

    public void setAvaibility(List<Availbility> avaibility) {
        this.avaibility = avaibility;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Salary> getSalary() {
        return salary;
    }

    public void setSalary(List<Salary> salary) {
        this.salary = salary;
    }
    public int getSalaryLength(){
        return this.salary.size();
    }
    public int getAvaibilityLength(){
        return this.avaibility.size();
    }
    public int getAvaibilitytimelength(){
        int counter = 0;
        for(Availbility aval : this.avaibility){
            if(!aval.checkNull()){
                counter += 4;
            }
        }
        return counter;
    }
    public int getTagsLength(){
        System.out.println(this.tags);
        return this.tags.size();
    }

}

