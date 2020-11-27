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

    public AppJobInfo(int id, String title, String description, float salary, float minhours, float maxhours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.minhours = minhours;
        this.maxhours = maxhours;
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



}
