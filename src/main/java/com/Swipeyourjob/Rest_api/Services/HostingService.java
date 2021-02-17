package com.Swipeyourjob.Rest_api.Services;


import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl.HostDaoImpl;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
                BufferedImage image = ImageIO.read(tempFile);

                File compressedImageFile = new File(tempFile + "2"+prefix);
                OutputStream os =new FileOutputStream(compressedImageFile);
                Iterator<ImageWriter> writers =  ImageIO.getImageWritersByFormatName(prefix);
                ImageWriter writer = (ImageWriter) writers.next();
                ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);

                ImageWriteParam param = writer.getDefaultWriteParam();

                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.05f);
                writer.write(null, new IIOImage(image, null, null), param);

                os.close();
                ios.close();
                writer.dispose();
                boolean uploadboolean =  HostImpl.uploadfile(tempFile);
            }else{
                System.out.println("nope");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return webhost +"/"+folder+"/" + file.getOriginalFilename();
    }
}
