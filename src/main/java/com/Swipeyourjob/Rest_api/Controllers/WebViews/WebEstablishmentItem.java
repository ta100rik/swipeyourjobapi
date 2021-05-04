package com.Swipeyourjob.Rest_api.Controllers.WebViews;

public class WebEstablishmentItem {
    public int id;
    public String establishmentName;

    public WebEstablishmentItem(int id, String establishmentName) {
        this.id = id;
        this.establishmentName = establishmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }
}
