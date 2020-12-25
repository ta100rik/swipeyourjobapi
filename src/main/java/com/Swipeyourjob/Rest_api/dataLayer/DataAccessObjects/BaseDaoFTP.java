package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects;

import com.Swipeyourjob.Rest_api.dataLayer.BaseDaoConnectionFtp;
import com.Swipeyourjob.Rest_api.dataLayer.BaseDaoConnectionPoolingMySQL;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;

public class BaseDaoFTP {
    public FTPClient getConnection(){
        return BaseDaoConnectionFtp.getINSTANCE().getCon();
    }
    public boolean storeFile(MultipartFile file, FTPClient client){
        try{
            boolean result = client.storeFile("/public_html/api_assets/" + file.getOriginalFilename(), file.getInputStream());
            return result;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean closeConnection(FTPClient client) {
        try {
            client.logout();
            client.disconnect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

