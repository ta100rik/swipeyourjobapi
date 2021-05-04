package com.Swipeyourjob.Rest_api.domain.ListClasses;

import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Card;
import com.Swipeyourjob.Rest_api.domain.Company.EstablishmentItem;

import java.util.ArrayList;
import java.util.List;

public class EstablishmentList {
    private List<EstablishmentItem> establishmentlist = new ArrayList<>();

    public List<EstablishmentItem> getEstablishmentlist() {
        return establishmentlist;
    }
    public boolean addestablishment(EstablishmentItem item){
        try{
            return this.establishmentlist.add(item);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
