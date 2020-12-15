package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppChatMessage;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.DaoImpl.ChatDaoImpl;
import com.Swipeyourjob.Rest_api.Controllers.AppViews.AppRoom;
import com.Swipeyourjob.Rest_api.domain.ChatMessage;
import com.Swipeyourjob.Rest_api.domain.ListClasses.GuestList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.RoomList;
import com.Swipeyourjob.Rest_api.domain.chatRoom;

import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private final ChatDaoImpl ChatImpl = new ChatDaoImpl();
    public int CreateRoom(int chatjobid, String chatname, int ownerid,List<Integer> guests) {
//        creating a room
        int roomid = ChatImpl.CreateRoom(chatjobid,chatname,ownerid);
//      creating a guest list class to do some preload validations
        GuestList guestlist = new GuestList(guests);
//      Adding the owner as guest and validating directly to prevent double guests
        Boolean check = guestlist.addGuest(ownerid);
        if(check){
            boolean addguests =  ChatImpl.addGuestsToRoom(roomid,guestlist.getGuests());
            if(addguests){
                return roomid;
            }else{
                return 0;
            }
        }else{
            roomid = 0;
        }
        return roomid;
    }
    public List<AppRoom> getPersonalRooms(String useridentifier,String start, String amount){
        RoomList current_list = ChatImpl.getRoomList(useridentifier,start,amount);
        List<AppRoom> app_list = new ArrayList<AppRoom>();
        for (chatRoom room : current_list.getRoomsList()){
            AppRoom new_room = new AppRoom(room.getRoom_id(),room.getChatname(),room.getChatjobid(),room.getRoomAdmin());
            app_list.add(new_room);
        }
        return app_list;
    }
    public boolean SendMessage(String userid, int roomid, String message){
        RoomList current_list = ChatImpl.getRoomList(userid,"0","1000");
        if(current_list.isRoomInList(roomid)){
            return ChatImpl.SendMessage(userid,roomid,message);
        }else{
            return false;
        }
    }
    public List<AppChatMessage> getChatHistoryRoom(int roomid, String userid,String amount){
        RoomList current_list = ChatImpl.getRoomList(userid,"0","1000");
        if(current_list.isRoomInList(roomid)){
             chatRoom chatroom = ChatImpl.getChatHistory(roomid,amount);
             List<AppChatMessage> messagelist = new ArrayList<AppChatMessage>();
             for (ChatMessage chatmessageobject : chatroom.getChatmessages()){
                 AppChatMessage message = new AppChatMessage(chatmessageobject.getChatmessage(),chatmessageobject.getUserid());
                 messagelist.add(message);
             }
             return messagelist;
        }else{
            return null;
        }
    }
}
