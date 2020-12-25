package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import org.springframework.web.multipart.MultipartFile;

public interface HostDao {
    public boolean uploadfile(MultipartFile file);
}
