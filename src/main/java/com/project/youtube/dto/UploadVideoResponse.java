package com.project.youtube.dto;

public class UploadVideoResponse {

	private String videoId;
	private String videoUrl;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public UploadVideoResponse(String bigInteger, String videoUrl) {
		super();
		this.videoId = bigInteger;
		this.videoUrl = videoUrl;
	}

	public UploadVideoResponse() {
		super();
	}

}
