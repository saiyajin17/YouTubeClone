package com.project.youtube.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.youtube.dto.CommentDto;
import com.project.youtube.dto.UploadVideoResponse;
import com.project.youtube.dto.VideoDto;
import com.project.youtube.model.Comment;
import com.project.youtube.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file) {
		return videoService.uploadVideo(file);
	}

	@PostMapping("/thumbnail")
	@ResponseStatus(HttpStatus.CREATED)
	public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) {
		return videoService.uploadThumbnail(file, videoId);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public VideoDto editVideoMetaData(@RequestBody VideoDto videodto) {
		return videoService.editVideo(videodto);
	}
	
	/*
	 * @GetMapping("/{videoId}")
	 * 
	 * @ResponseStatus(code = HttpStatus.OK) public VideoDto
	 * getVideoDetails(@PathVariable String videoId) { return
	 * videoService.getVideoDetails(videoId); }
	 */
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public VideoDto getVideoDetails(@RequestParam String videoId,@RequestParam String userId) {
		return videoService.getVideoDetails(videoId,userId);
	}
	
	@PostMapping("/like")
	@ResponseStatus(code = HttpStatus.OK)
	public VideoDto likeVideo(@RequestParam String videoId,@RequestParam String userId) {
		List<String> Ids= new ArrayList<String>();
		Ids.add(videoId);
		Ids.add(userId);
		return videoService.likeVideo(Ids);
	}
		
	@PostMapping("/dislike")
	@ResponseStatus(code = HttpStatus.OK)
	public VideoDto dislikeVideo(@RequestParam String videoId,@RequestParam String userId) {
		List<String> Ids= new ArrayList<String>();
		Ids.add(videoId);
		Ids.add(userId);
		 return videoService.dislikeVideo(Ids);
	}
	
	@PostMapping("/comment/{videoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void addComment(@PathVariable String videoId,@RequestBody CommentDto commentDto) {
		videoService.addComment(videoId,commentDto);
	}
	
	@GetMapping("/comment/{videoId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CommentDto> getAllComments(@PathVariable String videoId) {
		return videoService.getAllComments(videoId);
	}
	
	@GetMapping("/all")
	@ResponseStatus(code = HttpStatus.OK)
	public List<VideoDto> getAllVideos(){
		return videoService.getAllVideos();
	}
	
	
	
}
