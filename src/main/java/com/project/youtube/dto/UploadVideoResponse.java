package com.project.youtube.dto;

import java.math.BigInteger;

public class UploadVideoResponse {

	private BigInteger videoId;
	private String videoUrl;

	public BigInteger getVideoId() {
		return videoId;
	}

	public void setVideoId(BigInteger videoId) {
		this.videoId = videoId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public UploadVideoResponse(BigInteger bigInteger, String videoUrl) {
		super();
		this.videoId = bigInteger;
		this.videoUrl = videoUrl;
	}

	public UploadVideoResponse() {
		super();
	}

}
