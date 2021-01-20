package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects;


import com.Swipeyourjob.Rest_api.dataLayer.BaseDaoConnectionSMTP;

import javax.mail.Session;
import java.sql.Connection;

public class BaseDaoSMTP {
    public Session getMailSession(){
            Session session =  BaseDaoConnectionSMTP.getINSTANCE().getCurrentsession();
        return session;
    }

}
