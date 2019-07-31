package org.sample.s3.demo.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.sample.s3.demo.config.ApplicationProperties;
import org.sample.s3.demo.service.DocumentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class DocumentManagementServiceImpl implements DocumentManagementService {

    @Autowired
    private AmazonS3 s3Client;
    
    @Autowired
    private ApplicationProperties applicationProperties;
    
    @Override
    public void uploadMultipleFiles(List<MultipartFile> files) {
        if(files != null) {
            files.forEach(multipartFile -> {
                File file = convertMultiPartFileToFile(multipartFile);
                String uniqueFileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                uploadFileToS3bucket(uniqueFileName, file, applicationProperties.getAwsService().getBucketName());
            });
        }
    }    

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(DocumentManagementServiceImpl.class.getName()).log(Level.SEVERE, "Error converting multipartFile to file", ex);
        }
        
        return convertedFile;
    }

    private void uploadFileToS3bucket(String fileName, File file, String bucketName) {
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
    }
    
    private S3Object downloadFileFromS3bucket(String fileName, String bucketName) {
        S3Object object = s3Client.getObject(bucketName, fileName);
        return object;
    }
}
