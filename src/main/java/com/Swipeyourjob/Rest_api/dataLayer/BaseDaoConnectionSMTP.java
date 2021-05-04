package com.Swipeyourjob.Rest_api.dataLayer;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseDaoConnectionSMTP {
    private static final BaseDaoConnectionSMTP INSTANCE = new BaseDaoConnectionSMTP();
    private static Session currentsession;
    private static Properties props;
    private BaseDaoConnectionSMTP(){
        if(INSTANCE == null){
            currentsession = OpenSession();
        }
    }
    private Session OpenSession(){
        props = new Properties();
        props.put("mail.smtp.host", "mail.zxcs.nl"); //SMTP Host
        props.put("mail.smtp.port", "465"); //TLS Port
        // enable authentication
        props.put("mail.smtp.auth", "true");
        // SSL Factory

        props.put("mail.smtp.auth", "true"); //enable authentication
//        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");


        Authenticator auth = new javax.mail.Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("info@swipeyourjob.nl", "hV0FG0bZ");
            }
        };
        Session session = Session.getDefaultInstance(props, auth);
        return session;

    }
    public Session getCurrentsession(){
        return currentsession;
    }
    public static BaseDaoConnectionSMTP getINSTANCE() {
        return INSTANCE;
    }
}
