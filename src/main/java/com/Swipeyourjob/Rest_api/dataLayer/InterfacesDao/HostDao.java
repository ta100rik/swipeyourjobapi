package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface HostDao {
    public boolean uploadfile(File file);
}
