package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoSMTP;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class MailDaoImpl extends BaseDaoSMTP {
    static private String trellomail= "zyadosseyran+2zaaptjcqgr5xajfog0m@boards.trello.com";
    public Session getsession(){
        return super.getMailSession();
    }

    public static boolean sendToTrello(Session session, String subject, String body){
        try{
            MimeMessage msg  = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("swipeyourjob@gmail.com", "Swipeyourjob"));
            msg.setReplyTo(InternetAddress.parse("swipeyourjob@gmail.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(trellomail, false));
            System.out.println("Message is ready");
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean sendEmail(Session session, String toEmail, String subject, String body){
        try{
            MimeMessage msg  = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("swipeyourjob@gmail.com", "Swipeyourjob"));
            msg.setReplyTo(InternetAddress.parse("swipeyourjob@gmail.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
