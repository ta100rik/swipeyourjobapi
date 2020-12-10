package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.chatDao;
import com.Swipeyourjob.Rest_api.domain.ListClasses.GuestList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.RoomList;
import com.Swipeyourjob.Rest_api.domain.chatRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChatDaoImpl  extends BaseDaoMySQL implements chatDao {

    @Override
    public int CreateRoom(int chatjobid, String chatname, int ownerid) {

        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO chat_rooms (Chatname, chatjobid,roomadmin) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,chatname);
            preparedStatement.setInt(2,chatjobid);
            preparedStatement.setInt(3,ownerid);
            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public boolean addGuestsToRoom(int roomid,List<Integer> new_guest){
        try{

            GuestList guestlist = this.getGuestInRoom(roomid);
//            adding the new people to the list
           boolean add_member_boolean = guestlist.addGuestList(new_guest);
           if(add_member_boolean){
               for(int guest: new_guest){
                   Connection connection  = super.getConnection();
                   PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room_users (userid, room_id) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                   preparedStatement.setInt(1,guest);
                   preparedStatement.setInt(2,roomid);
                   super.executeQueryReturningId(preparedStatement,connection);
               }
               return true;

           }else{
               return false;
           }

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public RoomList getRoomList(String useridentifier,String start, String amount){
       try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "SELECT * FROM room_users  " +
                    "join chat_rooms " +
                    "on chat_rooms.idchat_rooms = room_users.room_id " +
                    "where userid = ? " +
                    "and room_id > ? " +
                    "limit ?");

            int ConvertedStart = Integer.parseInt(start);
            int ConvertedAmount = Integer.parseInt(amount);

            preparedStatement.setString(1,useridentifier);

            preparedStatement.setInt(2,ConvertedStart);

            preparedStatement.setInt(3,ConvertedAmount);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            // initiliaze domain item
            RoomList roomlist = new RoomList();
            while(result.next()){
                int guest_id = result.getInt("guest_id");
                String userid = result.getString("userid");
                int room_id = result.getInt("room_id");
                int idchat_rooms = result.getInt("idchat_rooms");
                String chatname = result.getString("chatname");
                int chatjobid = result.getInt("chatjobid");
                int roomAdmin = result.getInt("roomAdmin");
                chatRoom new_room = new chatRoom(guest_id,userid,room_id,idchat_rooms,chatname,chatjobid,roomAdmin);
                roomlist.addChatRoom(new_room);
            }
            return roomlist;

        }
        catch (Exception e){
        e.printStackTrace();
        return null;
        }
    }
    public GuestList getGuestInRoom(int roomid){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_users where room_id = ?");

            preparedStatement.setInt(1,roomid);
            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            List<Integer> CurrentGuestList = new ArrayList<Integer>();
            while(result.next()){
                int userid = result.getInt("userid");
                CurrentGuestList.add(userid);
            }
            GuestList guestlist = new GuestList(CurrentGuestList);
            return guestlist;

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
