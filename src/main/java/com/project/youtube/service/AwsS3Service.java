package com.project.youtube.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AwsS3Service implements FileService {

	
	@SuppressWarnings("deprecation")
	private AmazonS3Client awsS3Client= new AmazonS3Client(
			new AWSStaticCredentialsProvider(
					new BasicAWSCredentials(System.getProperty("accessKey"), System.getProperty("secretKey"))));

	public static final String Bucket_Name = "javastoragebucket";

	@Override
	public String uploadFile(MultipartFile file) {

		/* logic to upload the file to AWS */
		var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        var key = UUID.randomUUID().toString() + "."+filenameExtension;

        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(Bucket_Name, key, file.getInputStream(), metadata);
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "An Exception occured while uploading the file");
        }

        awsS3Client.setObjectAcl(Bucket_Name, key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl(Bucket_Name, key);
	}
}
