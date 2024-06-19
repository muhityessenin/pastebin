package pet.project.pastebin.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Service
public class S3Service {
    private final AmazonS3 s3client;

    @Value("${aws.bucket}")
    private String bucketName;

    public S3Service(AmazonS3 s3Client) {
        this.s3client = s3Client;
    }


    public void uploadFile(String keyName, MultipartFile file) throws IOException {
       s3client.putObject(bucketName, keyName, file.getInputStream(), null);
    }

    public void deleteFile(String keyName) throws IOException {
        s3client.deleteObject(bucketName, keyName);
    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }
}
