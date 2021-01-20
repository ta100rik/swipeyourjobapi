package com.Swipeyourjob.Rest_api.dataLayer;

import java.util.Properties;

public class BaseDaoConnectionSMTP {
    private static final BaseDaoConnectionSMTP INSTANCE = new BaseDaoConnectionSMTP();
    private BaseDaoConnectionSMTP(){
        if(INSTANCE == null) {
            openConnections = createConnection(url, dbuserName, dbpassword);
        }
    }


//prop.put("mail.smtp.auth", true);
//prop.put("mail.smtp.starttls.enable", "true");
//prop.put("mail.smtp.host", "smtp.mailtrap.io");
//prop.put("mail.smtp.port", "25");
//prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
}
