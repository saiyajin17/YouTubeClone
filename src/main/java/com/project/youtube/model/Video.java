package com.project.youtube.model;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.youtube.controller.VideoController;


@Document(value = "Video")
public class Video {

	@Id
	private String id;
	private String title;
	private String description;
	private String userId;
	private AtomicInteger likes=new AtomicInteger(0);
	private AtomicInteger dislikes=new AtomicInteger(0);
	private Set<String> tags;
	private String videoUrl;
	private VideoStatus videoStatus;
	private AtomicInteger viewCount = new AtomicInteger(0);
	private String thumbnail;
	private List<Comment> commentList = new CopyOnWriteArrayList<>();

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AtomicInteger getLikes() {
		return likes;
	}

	public void setLikes(AtomicInteger likes) {
		this.likes = likes;
	}

	public AtomicInteger getDislikes() {
		return dislikes;
	}

	public void setDislikes(AtomicInteger dislikes) {
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

	public AtomicInteger getViewCount() {
		return viewCount;
	}

	public void setViewCount(AtomicInteger viewCount) {
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

	public Video(String id, String title, String description, String userId, AtomicInteger likes, AtomicInteger dislikes,
			Set<String> tags, String videoUrl, VideoStatus videoStatus, AtomicInteger viewCount, String thumbnail,
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
	
	/****************Custom Methods******************************/
	public void incrementLikes() {
		likes.incrementAndGet();
	}
	
	public void decrementLikes() {
		likes.decrementAndGet();
	}
	
	
	public void incrementDislikes() {
		dislikes.incrementAndGet();
	}
	
	public void decrementDislikes() {
		dislikes.decrementAndGet();
	}

	public void incrementViewCount() {
		viewCount.incrementAndGet();
	}

	public void addComment(Comment comment) {
		commentList.add(comment);
	}
}

