package com.noah.raptorsImageRepo.service;

import org.springframework.web.multipart.MultipartFile;

public interface IRaptorsImageRepoService {
	
	void saveImage(MultipartFile image) throws Exception;
	
}
