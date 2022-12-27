package com.project.youtube.model;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "Video")
public class Video {

	@Id
	private BigInteger id;
	private String title;
	private String description;
	private String userId;
	private Integer likes;
	private Integer dislikes;
	private Set<String> tags;
	private String videoUrl;
	private VideoStatus videoStatus;
	private Integer viewCount;
	private String thumbnail;
	private List<Comment> commentList;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
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

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Video() {
		super();
	}

	public Video(BigInteger id, String title, String description, String userId, Integer likes, Integer dislikes,
			Set<String> tags, String videoUrl, VideoStatus videoStatus, Integer viewCount, String thumbnail,
			List<Comment> commentList) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.likes = likes;
		this.dislikes = dislikes;
		this.tags = tags;
		this.videoUrl = videoUrl;
		this.videoStatus = videoStatus;
		this.viewCount = viewCount;
		this.thumbnail = thumbnail;
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", description=" + description + ", userId=" + userId
				+ ", likes=" + likes + ", dislikes=" + dislikes + ", tags=" + tags + ", videoUrl=" + videoUrl
				+ ", videoStatus=" + videoStatus + ", viewCount=" + viewCount + ", thumbnail=" + thumbnail
				+ ", commentList=" + commentList + "]";
	}

}
