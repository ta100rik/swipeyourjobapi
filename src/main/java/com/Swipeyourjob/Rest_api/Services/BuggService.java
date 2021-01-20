package com.Swipeyourjob.Rest_api.Services;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.BuggDaoImpl;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.MailDaoImpl;

public class BuggService {
    private final BuggDaoImpl BuggImpl = new BuggDaoImpl();
    private final MailDaoImpl MailImpl = new MailDaoImpl();
    public int newBug(String userid,String username, String description, String versionnumber){
        int RESULT = BuggImpl.newBug(userid,username,description,versionnumber);
        String trelloboard = "<table>" +
                "<tbody>" +
                "   <tr>" +
                "       <td>Username:</td>" +
                "       <td>"+username+"</td>" +
                "   </tr>" +
                "   <tr>" +
                "       <td>Versionnumber:</td>" +
                "       <td>"+username+"</td>" +
                "   </tr>" +
                "</tbody> " +
                "</table>";
        MailDaoImpl.sendToTrello(MailImpl.getsession(),description,trelloboard);
        return RESULT;
    }


}
