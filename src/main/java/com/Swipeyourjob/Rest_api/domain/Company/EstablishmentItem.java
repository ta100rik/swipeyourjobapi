package com.Swipeyourjob.Rest_api.domain.Company;

public class EstablishmentItem {
    public int id;
    public String establishmentName;

    public EstablishmentItem(int id, String establishmentName) {
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
