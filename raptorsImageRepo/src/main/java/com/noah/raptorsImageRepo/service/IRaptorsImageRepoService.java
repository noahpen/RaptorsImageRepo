package com.noah.raptorsImageRepo.service;

import org.springframework.web.multipart.MultipartFile;

import com.noah.raptorsImageRepo.dto.ImageDTO;

public interface IRaptorsImageRepoService {
	
	void saveImage(MultipartFile imageFile, ImageDTO imageDTO) throws Exception;
	
}
