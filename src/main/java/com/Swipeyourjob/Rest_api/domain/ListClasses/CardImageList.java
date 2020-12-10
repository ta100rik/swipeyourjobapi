package com.Swipeyourjob.Rest_api.domain.ListClasses;

import com.Swipeyourjob.Rest_api.domain.CardImage;

import java.util.ArrayList;
import java.util.List;

public class CardImageList {
    private List<CardImage> CardImageList = new ArrayList<>();

    public List<CardImage> getCardImageList() {
        return CardImageList;
    }

   public boolean addCardimage(CardImage imageobject){
       try{
        return this.CardImageList.add(imageobject);
       }
       catch (Exception e){
           e.printStackTrace();
           return false;
       }
   }
}
