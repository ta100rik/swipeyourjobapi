package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.chatDao;
import com.Swipeyourjob.Rest_api.domain.ChatMessage;
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
//    this one is also getting the last messageid of the chat
    public boolean readmessages(String userid, int roomid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement lastmessageStatement = connection.prepareStatement("SELECT chatid FROM chatmessages where roomid = ? order by chatid desc limit 1;");
            lastmessageStatement.setInt(1,roomid);
            ResultSet result = super.executeQuery(lastmessageStatement,connection);
            while(result.next()){
                int chatid = result.getInt("chatid");
                PreparedStatement insertreadstatement = connection.prepareStatement("INSERT INTO showedmessages(messageid,roomid,userid) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
                insertreadstatement.setInt(1,chatid);
                insertreadstatement.setInt(2,roomid);
                insertreadstatement.setString(3,userid);
                int newitem = super.executeQueryReturningId(insertreadstatement,connection);
                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
//    this one you need to provide the last chat id
    public boolean readmessages(String userid, int roomid,int chatid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement insertreadstatement = connection.prepareStatement("INSERT INTO showedmessages(messageid,roomid,userid) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            insertreadstatement.setInt(1,chatid);
            insertreadstatement.setInt(2,roomid);
            insertreadstatement.setString(3,userid);
            int newitem = super.executeQueryReturningId(insertreadstatement,connection);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public int CreateRoom(int chatjobid, String chatname, String ownerid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO chat_rooms (Chatname, chatjobid,roomadmin) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,chatname);
            preparedStatement.setInt(2,chatjobid);
            preparedStatement.setString(3,ownerid);
            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public boolean addGuestsToRoom(int roomid,List<String> new_guest){
        try{

            GuestList guestlist = this.getGuestInRoom(roomid);
//            adding the new people to the list
           boolean add_member_boolean = guestlist.addGuestList(new_guest);
           if(add_member_boolean){
               for(String guest: new_guest){
                   Connection connection  = super.getConnection();
                   PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room_users (userid, room_id) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                   preparedStatement.setString(1,guest);
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
                    "SELECT *, " +
                    "(SELECT timestampmessage FROM chatmessages where roomid = room_users.room_id order by timestampmessage desc limit 1)  as 'TimestampLastMessage', " +
                    "(SELECT chatmessage FROM chatmessages where roomid = room_users.room_id order by chatid desc limit 1)  as 'lastmessage' " +
                    "FROM room_users  " +
                    "join chat_rooms " +
                    "on chat_rooms.idchat_rooms = room_users.room_id " +
                    "join jobs " +
                    "on jobs.jobid = chat_rooms.chatjobid " +
                    "join companies " +
                    "on companies.company_id = jobs.establishment_companies_company_id " +
                    "where room_users.userid = ? " +
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
               String chatname = result.getString("Chatname");
                int chatjobid = result.getInt("chatjobid");
                String roomAdmin = result.getString("roomAdmin");
                String jobTitle = result.getString("jobtitle");
                String companylogo = result.getString("companylogo");
                String companyName = result.getString("name");
                String lastmessage = result.getString("lastmessage");
                boolean lastmessagebool = true;
                chatRoom new_room = new chatRoom(guest_id,userid,room_id,idchat_rooms,chatname,chatjobid,roomAdmin,jobTitle,companylogo,lastmessage,lastmessagebool,companyName);
                roomlist.addChatRoom(new_room);
            }
            return roomlist;

        }
        catch (Exception e){
        e.printStackTrace();
        return null;
        }
    }
    public int CountUserRooms(String userid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) as 'roomamount' from room_users where userid = ?");
            preparedStatement.setString(1,userid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            while(result.next()){
                return result.getInt("roomamount");
            }
        }catch (Exception e){
            return 0;
        }
        return 0;
    }
    public GuestList getGuestInRoom(int roomid){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_users where room_id = ?");

            preparedStatement.setInt(1,roomid);
            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            List<String> CurrentGuestList = new ArrayList<String>();
            while(result.next()){
                String userid = result.getString("userid");
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
    public boolean SendMessage(String userid, int roomid, String message){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO chatmessages (chatmessage, roomid, userid) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,message);
            preparedStatement.setInt(2,roomid);
            preparedStatement.setString(3,userid);
            super.executeQueryReturningId(preparedStatement,connection);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public chatRoom getChatHistory(int roomid, String amount){
        try{
            chatRoom chatroom = new chatRoom(roomid);
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chatmessages " +
                    "left join webusers " +
                    "on webusers.idwebusers = chatmessages.userid " +
                    "where roomid = ? order by timestampmessage limit ?");
            int ConvertedAmount = Integer.parseInt(amount);
            preparedStatement.setInt(1,roomid);
            preparedStatement.setInt(2,ConvertedAmount);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            while(result.next()){
                String userid = result.getString("userid");
                String chatmessage = result.getString("chatmessage");
                int chatid = result.getInt("chatid");
                String firstname = result.getString("firstname");
                ChatMessage chatMessageObject = new ChatMessage(chatmessage, userid,chatid,firstname);
                chatroom.addMessage(chatMessageObject);
            }
            return chatroom;
            // initiliaze domain item

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
