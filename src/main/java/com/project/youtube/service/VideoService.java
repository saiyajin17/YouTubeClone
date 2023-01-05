package com.project.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.youtube.dto.UploadVideoResponse;
import com.project.youtube.dto.VideoDto;
import com.project.youtube.model.Video;
import com.project.youtube.model.VideoStatus;
import com.project.youtube.repository.VideoRepository;

@Service

public class VideoService {

	@Autowired
	private AwsS3Service awsS3Service;

	@Autowired
	private VideoRepository videoRepository;

	public UploadVideoResponse uploadVideo(MultipartFile file) {
		// upload file to aws-s3 and save vide data to database

		String videoUrl = awsS3Service.uploadFile(file);
		var video = new Video();
		video.setVideoUrl(videoUrl);
		Video savedVideo = videoRepository.save(video);
		return new UploadVideoResponse(savedVideo.getId(),savedVideo.getVideoUrl());
	}

	public VideoDto editVideo(VideoDto videodto) {

		// find the video by videoID
		Video savedVideo = getVideoById(videodto.getId());

		// map the videodto to video
		savedVideo.setTitle(videodto.getTitle());
		savedVideo.setDescription(videodto.getDescription());
		savedVideo.setTags(videodto.getTags());
		savedVideo.setThumbnail(videodto.getThumbnailUrl());
		savedVideo.setVideoStatus(videodto.getVideoStatus());

		// save the video to the database
		videoRepository.save(savedVideo);
		return videodto;
	}

	public String uploadThumbnail(MultipartFile file, String videoId) {
		Video savedVideo = getVideoById(videoId);
		String thumbUrl = awsS3Service.uploadFile(file);
		savedVideo.setThumbnail(thumbUrl);
		videoRepository.save(savedVideo);
		return thumbUrl;

	}

	Video getVideoById(String videoId) {
		return videoRepository.findById(videoId);
	}

	public VideoDto getVideoDetails(String videoId) {
		Video video= getVideoById(videoId);
		
		VideoDto vidDto= new VideoDto();
		vidDto.setVideoUrl(video.getVideoUrl());
		vidDto.setThumbnailUrl(video.getThumbnail());
		vidDto.setDescription(video.getDescription());
		vidDto.setTags(video.getTags());
		vidDto.setTitle(video.getTitle());
		vidDto.setId(video.getId().toString());
		
		return vidDto;
	}
}
