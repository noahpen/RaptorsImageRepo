package com.noah.raptorsImageRepo.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.noah.raptorsImageRepo.MainController;
import com.noah.raptorsImageRepo.dao.IImageDAO;
import com.noah.raptorsImageRepo.dto.ImageDTO;
import com.noah.raptorsImageRepo.utils.ImageUtils;

@Component
public class ImageService implements IImageService {
	
	protected static final Logger log = LogManager.getLogger(ImageService.class);
	
	@Autowired
	IImageDAO imageDAO;

	@Override
	public void saveImage(MultipartFile imageFile, ImageDTO imageDTO) throws Exception {
		String photosDir = ImageUtils.getAbsolutePath();
		if (imageFile != null) {
			byte[] bytes = imageFile.getBytes();
			Path path = Paths.get(photosDir + imageFile.getOriginalFilename());
			Files.write(path, bytes);
		}
		imageDTO.setPath(photosDir);
		imageDAO.save(imageDTO);
	}
	
	@Override
	public Iterable<ImageDTO> fetchAllImages() throws Exception {
		return imageDAO.fetchAll();
	}
	
	@Override
	public void deleteImage(int imageId) throws Exception {
		String fileName = null;
		List<Integer> imageIds = new ArrayList<>();
		imageIds.add(imageId);
		Iterable<ImageDTO> imageDTOs = imageDAO.fetchByIds(imageIds);
		for (ImageDTO imageDTO : imageDTOs) {
			fileName = imageDTO.getFileName();
		}
		try {
			String photosDir = ImageUtils.getAbsolutePath();
			File file = new File(photosDir + fileName);
			if (file.delete()) {
				log.debug("Image file " + fileName + " has been successfully deleted.");
			} else {
				log.error("Error: Delete operation for image file " + fileName + " failed.");
			}
		} catch (Exception e) {
			log.error("Error: Delete operation for image file " + fileName + " failed.");
		}
		imageDAO.delete(imageId);
	}

}
