package com.Swipeyourjob.Rest_api.domain.ListClasses;

import java.util.List;
import java.util.stream.Collectors;

public class GuestList {
    private List<Integer> guests;
    public GuestList(List<Integer> guests) {
        this.guests = guests;
    }

    public List<Integer> getGuests() {
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
    public boolean addGuestList(List<Integer> guests){
//        bolean to check if they can be added to the list
        boolean validateBolean = true;
        for (int guest: guests){
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
    private boolean addGuestWithoutCheck(int guest){
        try{
            guests.add(guest);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean addGuest(int newGuestId){
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
