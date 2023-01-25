package com.project.youtube.dto;

public class CommentDto {
	private String commentText;
	private String authorId;

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public CommentDto(String commentText, String authorId) {
		super();
		this.commentText = commentText;
		this.authorId = authorId;
	}

	public CommentDto() {
		super();
	}

}
