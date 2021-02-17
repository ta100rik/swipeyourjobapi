package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoFTP;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.HostDao;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class HostDaoImpl extends BaseDaoFTP implements HostDao  {
    public boolean uploadfile(File file){
        try{
            FTPClient client = super.getConnection();
            super.storeFile(file,client);
            super.closeConnection(client);
            return true;
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }
}
