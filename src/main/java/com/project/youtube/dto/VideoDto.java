package com.project.youtube.dto;


import java.util.Set;

import com.project.youtube.model.VideoStatus;

public class VideoDto {

	private String id;
	private String title;
	private String description;
	private Set<String> tags;
	private String videoUrl;
	private VideoStatus videoStatus;
	private String thumbnailUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public VideoStatus getVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(VideoStatus videoStatus) {
		this.videoStatus = videoStatus;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public VideoDto(String id, String title, String description, Set<String> tags, String videoUrl,
			VideoStatus videoStatus, String thumbnailUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.videoUrl = videoUrl;
		this.videoStatus = videoStatus;
		this.thumbnailUrl = thumbnailUrl;
	}

	public VideoDto() {
		super();
	}

	@Override
	public String toString() {
		return "VideoDto [id=" + id + ", title=" + title + ", description=" + description + ", tags=" + tags
				+ ", videoUrl=" + videoUrl + ", videoStatus=" + videoStatus + ", thumbnailUrl=" + thumbnailUrl + "]";
	}
}
