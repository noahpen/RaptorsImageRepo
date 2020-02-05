package com.noah.raptorsImageRepo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class RaptorsImageRepoService implements IRaptorsImageRepoService {

	@Override
	public void saveImage(MultipartFile image) throws Exception {
		String folder = "/Projects/photos/";
		byte[] bytes = image.getBytes();
		Path path = Paths.get(folder + image.getOriginalFilename());
		Files.write(path, bytes);
	}

}
