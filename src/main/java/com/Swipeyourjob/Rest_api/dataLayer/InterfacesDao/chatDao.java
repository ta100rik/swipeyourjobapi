package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import java.util.List;

public interface chatDao {
    int CreateRoom(int chatjobid, String chatname, String ownerid);
    boolean SendMessage(String userid, int roomid, String message);
    boolean readmessages(String userid, int roomid);
    boolean readmessages(String userid, int roomid,int chatid);
}
