package com.project.youtube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.youtube.dto.CommentDto;
import com.project.youtube.dto.UploadVideoResponse;
import com.project.youtube.dto.VideoDto;
import com.project.youtube.model.Comment;
import com.project.youtube.model.Video;
import com.project.youtube.repository.VideoRepository;

@Service

public class VideoService {

	@Autowired
	private AwsS3Service awsS3Service;
	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private UserService userService;

	public UploadVideoResponse uploadVideo(MultipartFile file) {

		String videoUrl = awsS3Service.uploadFile(file);
		var video = new Video();
		video.setVideoUrl(videoUrl);
		Video savedVideo = videoRepository.save(video);
		return new UploadVideoResponse(savedVideo.getId(), savedVideo.getVideoUrl());
	}

	public VideoDto editVideo(VideoDto videodto) {

		Video savedVideo = getVideoById(videodto.getId());

		savedVideo.setTitle(videodto.getTitle());
		savedVideo.setDescription(videodto.getDescription());
		savedVideo.setTags(videodto.getTags());
		savedVideo.setThumbnail(videodto.getThumbnailUrl());
		savedVideo.setVideoStatus(videodto.getVideoStatus());

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
		return videoRepository.findById(videoId)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + videoId));
	}

	public VideoDto getVideoDetails(String videoId, String userId) {
		Video video = getVideoById(videoId);

		increaseVideoCount(video);
		userService.addToVideoHistory(videoId, userId);

		return getVidDto(video);
	}

	private void increaseVideoCount(Video savedvideo) {
		savedvideo.incrementViewCount();
		videoRepository.save(savedvideo);
	}

	public VideoDto likeVideo(List<String> Ids) {

		// firstID-videoId secondID-userId
		String videoId = Ids.get(0);
		String userId = Ids.get(1);
		Video videoById = getVideoById(videoId);

		if (userService.ifLikedVideo(videoId, userId)) {
			videoById.decrementLikes();
			userService.removeFromLikedVideos(videoId, userId);
		} else if (userService.ifDisLikedVideo(videoId, userId)) {
			videoById.decrementDislikes();
			userService.removeFromDisLikedVideo(videoId, userId);
			videoById.incrementLikes();
			userService.addToLikedVideos(videoId, userId);
		} else {
			videoById.incrementLikes();
			userService.addToLikedVideos(videoId, userId);
		}
		videoRepository.save(videoById);
		return getVidDto(videoById);

	}

	public VideoDto dislikeVideo(List<String> ids) {
		// firstID-videoId secondID-userId
		String videoId = ids.get(0);
		String userId = ids.get(1);
		Video videoById = getVideoById(videoId);

		if (userService.ifDisLikedVideo(videoId, userId)) {
			videoById.decrementDislikes();
			userService.removeFromDisLikedVideo(videoId, userId);
		} else if (userService.ifLikedVideo(videoId, userId)) {
			videoById.decrementLikes();
			userService.removeFromLikedVideos(videoId, userId);
			videoById.incrementDislikes();
			userService.addToDisLikedVideos(videoId, userId);
		} else {
			videoById.incrementDislikes();
			userService.addToDisLikedVideos(videoId, userId);
		}
		videoRepository.save(videoById);

		return getVidDto(videoById);
	}

	public void addComment(String videoId, CommentDto commentDto) {
		Video videoById = getVideoById(videoId);
		Comment comment= new Comment();
		comment.setText(commentDto.getCommentText());
		comment.setAuthor(commentDto.getAuthorId());
		videoById.addComment(comment);
		
		videoRepository.save(videoById);
	}
	
	private VideoDto getVidDto(Video video) {
		VideoDto vidDto = new VideoDto();
		vidDto.setVideoUrl(video.getVideoUrl());
		vidDto.setThumbnailUrl(video.getThumbnail());
		vidDto.setDescription(video.getDescription());
		vidDto.setTags(video.getTags());
		vidDto.setTitle(video.getTitle());
		vidDto.setId(video.getId());
		vidDto.setLikeCount(video.getLikes().get());
		vidDto.setDislikeCount(video.getDislikes().get());
		vidDto.setViewCount(video.getViewCount().get());

		return vidDto;
	}

	public List<CommentDto> getAllComments(String videoId) {
		Video videoById = getVideoById(videoId);
		List<Comment> commentList = videoById.getCommentList();
		return commentList.stream().map(comment->mapToCommentDto(comment)).toList();
	}
	
	private CommentDto mapToCommentDto(Comment comment) {
		CommentDto dto= new CommentDto();
		dto.setAuthorId(comment.getAuthor());
		dto.setCommentText(comment.getText());
		return dto;
	}

	public List<VideoDto> getAllVideos() {
		return videoRepository.findAll().stream().map(video->getVidDto(video)).toList();
	}
	
}
