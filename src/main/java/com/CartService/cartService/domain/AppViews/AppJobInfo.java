package com.CartService.cartService.domain.AppViews;

public class AppJobInfo {
    private int id;
    private String title;
    private String description;
    private float salary;
    private int minhours;
    private int maxhours;

    public AppJobInfo(int id, String title, String description, float salary, int minhours, int maxhours) {
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

    public int getMinhours() {
        return minhours;
    }

    public void setMinhours(int minhours) {
        this.minhours = minhours;
    }

    public int getMaxhours() {
        return maxhours;
    }

    public void setMaxhours(int maxhours) {
        this.maxhours = maxhours;
    }



}
