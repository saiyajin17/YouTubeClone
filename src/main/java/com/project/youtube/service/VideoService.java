package com.project.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.youtube.model.Video;
import com.project.youtube.repository.VideoRepository;

@Service

public class VideoService {

	@Autowired
	private AwsS3Service awsS3Service;

	@Autowired
	private VideoRepository videoRepository;

	public void uploadVideo(MultipartFile file) {
		// upload file to aws-s3 and save vide data to database

		String videoUrl = awsS3Service.uploadFile(file);
		var video = new Video();
		video.setVideoUrl(videoUrl);
		videoRepository.save(video);
	}

}
