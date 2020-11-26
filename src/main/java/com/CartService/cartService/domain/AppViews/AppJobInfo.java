package com.CartService.cartService.domain.AppViews;

import com.CartService.cartService.domain.CardImage;

import java.util.ArrayList;
import java.util.List;

public class AppJobInfo {
    private int id;
    private String title;
    private String description;
    private float salary;
    private float minhours;
    private float maxhours;
    private AppLocation location;
    private List<String> images = new ArrayList<>();

    public AppJobInfo(int id, String title, String description, float salary, float minhours, float maxhours, AppLocation location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.minhours = minhours;
        this.maxhours = maxhours;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getMinhours() {
        return minhours;
    }

    public void setMinhours(float minhours) {
        this.minhours = minhours;
    }

    public float getMaxhours() {
        return maxhours;
    }

    public void setMaxhours(float maxhours) {
        this.maxhours = maxhours;
    }

    public AppLocation getLocation() {
        return location;
    }

    public void setLocation(AppLocation location) {
        this.location = location;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    public Boolean addImage(String imageurl){
        images.add(imageurl);
        return true;
    }

}
