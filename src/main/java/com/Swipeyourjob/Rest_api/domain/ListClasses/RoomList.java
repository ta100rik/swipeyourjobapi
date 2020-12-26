package com.Swipeyourjob.Rest_api.domain.ListClasses;

import com.Swipeyourjob.Rest_api.domain.chatRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomList {

    private List<chatRoom> RoomsList = new ArrayList<chatRoom>();

    public List<chatRoom> getRoomsList() {
        return RoomsList;
    }

    public boolean addChatRoom(chatRoom room){
        try{
            return this.RoomsList.add(room);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean isRoomInList(int searchroomid){
        for (chatRoom room : this.RoomsList){
            int roomid = room.getRoom_id();
            if(roomid == searchroomid){
                return true;
            }
        }
        return false;
    }
}
