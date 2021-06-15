package com.Swipeyourjob.Rest_api.services;


import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.HostDaoImpl;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class HostingService {
    private String webhost = "https://swipeyourjob.nl";
    private String folder  = "api_assets";
    private final HostDaoImpl HostImpl = new HostDaoImpl();
    public String UploadImage(MultipartFile file){
        try {
            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            File tempFile = File.createTempFile(fileName, prefix);
            file.transferTo(tempFile);
            String mimetype= new MimetypesFileTypeMap().getContentType(tempFile);
            String type = mimetype.split("/")[0];
            if(type.equals("image")){
//                time to compress the file
                File compressedImageFile = new File(file.getOriginalFilename());

                InputStream inputStream = new FileInputStream(tempFile);
                OutputStream outputStream = new FileOutputStream(compressedImageFile);
                float imageQuality = 0.6f;
                BufferedImage bufferedImage =  ImageIO.read(inputStream);
                String prefixwithouthpoint = prefix.replace(".","");
                Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName(prefixwithouthpoint);
                ImageWriter writer = (ImageWriter) imageWriters.next();

                ImageOutputStream ios = ImageIO.createImageOutputStream(outputStream);
                writer.setOutput(ios);
                ImageWriteParam param = writer.getDefaultWriteParam();
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(imageQuality);
                writer.write(null, new IIOImage(bufferedImage, null, null), param);

                outputStream.close();
                ios.close();
                writer.dispose();

                boolean uploadboolean =  HostImpl.uploadfile(compressedImageFile);
                return webhost +"/"+folder+"/" + compressedImageFile.getName();
            }else{
                boolean uploadboolean =  HostImpl.uploadfile(tempFile); 
                return webhost +"/"+folder+"/" + tempFile.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    private static String getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

}
