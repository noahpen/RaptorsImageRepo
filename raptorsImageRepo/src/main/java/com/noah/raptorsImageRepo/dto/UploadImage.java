package com.noah.raptorsImageRepo.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {

	private MultipartFile image;
	private String playerName;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
