package com.project.youtube.model;


public class Comment {

	private int id;
	private String text;
	private String author;
	private Integer likeCount;
	private Integer dislikeCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(Integer dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public Comment(int id, String text, String author, Integer likeCount, Integer dislikeCount) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", author=" + author + ", likeCount=" + likeCount
				+ ", dislikeCount=" + dislikeCount + "]";
	}

}
