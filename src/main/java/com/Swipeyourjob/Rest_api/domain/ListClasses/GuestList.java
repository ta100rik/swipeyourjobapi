package com.Swipeyourjob.Rest_api.domain.ListClasses;

import java.util.List;
import java.util.stream.Collectors;

public class GuestList {
    private List<String> guests;
    public GuestList(List<String> guests) {
        this.guests = guests;
    }

    public List<String> getGuests() {
        return guests;
    }

    public boolean ValidateGuestList(){
        try{
            this.removeDuplicates();
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    public boolean addGuestList(List<String> guests){
//        bolean to check if they can be added to the list
        boolean validateBolean = true;
        for (String guest: guests){
            boolean currentuser = this.addGuestWithoutCheck(guest);
            if(!currentuser){
                validateBolean = currentuser;
            }
        }

//        checking if everybody went in otherwise just send false didn't worked out
        if(validateBolean){
//            when everybody is in we validate and send back if it is valid
            return this.ValidateGuestList();
        }else{
            return false;
        }

    }
    private boolean addGuestWithoutCheck(String guest){
        try{
            guests.add(guest);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean addGuest(String newGuestId){
        try{
            guests.add(newGuestId);
            this.ValidateGuestList();
            return true;
        }catch (Exception e){
            return false;
        }

    }
    private void removeDuplicates(){
        this.guests = this.guests.stream()
                .distinct()
                .collect(Collectors.toList());

    }
}
