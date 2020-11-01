package com.CartService.cartService.domain.AppViews;

import com.CartService.cartService.domain.CardImage;

import java.util.ArrayList;
import java.util.List;

public class AppCard {
    private int id;
    private String title;
    private String description;
    private String location;
    private String companyName;
    private List<String> images = new ArrayList<>();

    public AppCard(int id, String title, String description, String location, String companyName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getImages() {
        return images;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean addImage(String imageUrl){
       return this.images.add(imageUrl);
    }


}
