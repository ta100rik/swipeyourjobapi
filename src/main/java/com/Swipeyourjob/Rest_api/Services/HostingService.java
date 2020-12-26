package com.Swipeyourjob.Rest_api.Services;


import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.HostDaoImpl;
import org.springframework.web.multipart.MultipartFile;

public class HostingService {
    private String webhost = "https://swipeyourjob.nl";
    private String folder  = "api_assets";
    private final HostDaoImpl HostImpl = new HostDaoImpl();
    public String UploadImage(MultipartFile file){
        boolean uploadboolean =  HostImpl.uploadfile(file);
        return webhost +"/"+folder+"/" + file.getOriginalFilename();
    }
}
