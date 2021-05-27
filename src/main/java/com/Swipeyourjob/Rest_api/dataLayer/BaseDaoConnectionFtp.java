package com.Swipeyourjob.Rest_api.dataLayer;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class BaseDaoConnectionFtp {
    private static final BaseDaoConnectionFtp INSTANCE = new BaseDaoConnectionFtp();

    private String FTP_ADDRESS = "web0138.zxcs.nl";
    private String LOGIN = "developer@swipeyourjob.nl";
    private String PSW = "$wipeY0urJ0b123485";

    private FTPClient con = null;

    public FTPClient getCon() {
        try {
            this.con = new FTPClient();
            this.con.connect(FTP_ADDRESS);
            if (this.con.login(LOGIN, PSW)) {
                this.con.enterLocalPassiveMode(); // important!
                this.con.setFileType(FTP.BINARY_FILE_TYPE);
                return this.con;
            }else{
                System.out.println("Invalid login credentials on ftp " + FTP_ADDRESS);
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public boolean releaseConnection(FTPClient client){
        try{
            this.con.logout();
            this.con.disconnect();
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public static BaseDaoConnectionFtp getINSTANCE() {
        return INSTANCE;
    }
}
