package com.noah.raptorsImageRepo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.noah.raptorsImageRepo.dao.IImageDAO;
import com.noah.raptorsImageRepo.dto.ImageDTO;

@Component
public class ImageService implements IImageService {
	
	@Autowired
	IImageDAO imageDAO;

	@Override
	public void saveImage(MultipartFile imageFile, ImageDTO imageDTO) throws Exception {
		// Current path
		Path currPath = Paths.get(".");
		// Absolute path
		Path absPath = currPath.toAbsolutePath();
		String photosDir = absPath + "/src/main/resources/static/photos/";
		if (imageFile != null) {
			byte[] bytes = imageFile.getBytes();
			Path path = Paths.get(photosDir + imageFile.getOriginalFilename());
			Files.write(path, bytes);
		}
		imageDTO.setPath(photosDir);
		imageDAO.save(imageDTO);
	}

}
