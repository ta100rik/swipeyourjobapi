package com.Swipeyourjob.Rest_api.services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.MailDaoImpl;

public class WebsiteService {
    private final MailDaoImpl MailImpl = new MailDaoImpl();
    public boolean newContact(String email, String desc){
        MailImpl.sendEmail(MailImpl.getsession(),"info@swipeyourjob.nl","Er is contact opgenomen met ons.",desc + " <br><br>" + email);
        return true;
    }
}
