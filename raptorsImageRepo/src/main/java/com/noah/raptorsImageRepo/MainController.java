package com.noah.raptorsImageRepo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.noah.raptorsImageRepo.dto.UploadImage;
import com.noah.raptorsImageRepo.service.IRaptorsImageRepoService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {
	
	protected static final Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	private IRaptorsImageRepoService raptorsImageRepoService;

	@RequestMapping(method=RequestMethod.POST, value="/upload-image")
//	public void uploadImage(@RequestBody UploadImage uploadImage) {
	public String uploadImage(@RequestParam("image") MultipartFile image) {
		try {
			raptorsImageRepoService.saveImage(image);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Image failed to save...", e);
			return "error";
		}
		return "index";
	}
	
}
