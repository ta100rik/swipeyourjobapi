package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import java.util.List;

public interface chatDao {
    public int CreateRoom(int chatjobid, String chatname, int ownerid);
    public boolean SendMessage(String userid, int roomid, String message);
}
