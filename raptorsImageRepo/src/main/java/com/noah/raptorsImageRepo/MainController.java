package com.noah.raptorsImageRepo;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.noah.raptorsImageRepo.dto.ImageDTO;
import com.noah.raptorsImageRepo.service.IImageService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	protected static final Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	private IImageService imageService;

	@RequestMapping("/")
	public ModelAndView getImages() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Iterable<ImageDTO> allImages = imageService.fetchAllImages();
			modelAndView.setViewName("index");
			modelAndView.addObject("allImages", allImages);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to retrieve image and data...", e);
			modelAndView.setViewName("error");
			return modelAndView;
		}
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload-image")
	public ModelAndView uploadImage(@ModelAttribute("imageDTO") ImageDTO imageDTO, @RequestParam("image") MultipartFile imageFile) {
		ModelAndView modelAndView = new ModelAndView();
		imageDTO.setFileName(imageFile.getOriginalFilename());
		try {
			imageService.saveImage(imageFile, imageDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Image failed to save...", e);
			modelAndView.setViewName("error");
			return modelAndView;
		}
		modelAndView.setViewName("index");
		modelAndView.addObject("imageDTO", imageDTO);
		return modelAndView;
	}
	
}
