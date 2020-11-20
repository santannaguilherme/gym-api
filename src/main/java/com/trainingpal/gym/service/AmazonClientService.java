package com.trainingpal.gym.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

@Service
public class AmazonClientService {
	
	private AmazonS3 s3Client;
	
	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;
	@Value("${amazonProperties.bucketUrl}")
	private String bucketUrl;
	
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		this.s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	} 
	
	
	public String uploadFile(MultipartFile multipartFile) {
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile.getOriginalFilename());
			fileUrl = bucketUrl + fileName;
			uploadFileToS3Bucket(fileName, file);
			file.delete();
		} catch (Exception e) {
			return "An Error Ocurred";
		}
		
		return fileUrl;
	}
	
	public String deleteFile(String fileUrl) {
		try {
			this.deleteFileToS3Bucket(fileUrl);
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return fileUrl;
	}
	
	private String generateFileName(String fileName) {
		return new Date().getTime() + "-" + fileName;
	}
	
	
	private void uploadFileToS3Bucket(String fileName, File file) {
		this.s3Client.putObject(
				new PutObjectRequest(this.bucketName, fileName, file)
		);
		
		
	}
	
	private void deleteFileToS3Bucket(String fileUrl) {
		this.s3Client.deleteObject(
				new DeleteObjectRequest(this.bucketName,fileUrl)
		);
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
