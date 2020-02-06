package com.noah.raptorsImageRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.noah.raptorsImageRepo.dao.IImageDAO;
import com.noah.raptorsImageRepo.dto.ImageDTO;
import com.noah.raptorsImageRepo.service.IImageService;


@SpringBootTest
class RaptorsImageRepoApplicationTests {

	@Autowired
	private IImageService imageService;
	private ImageDTO imageDTO;
	
	@MockBean
	private IImageDAO imageDAO;
	
	@Test
	private void testAddToDB() throws Exception {
		imageDTO.setPath("/example/path/here");
		imageDTO.setFileName("lowry.jpg");
		imageDTO.setCaption("Raptors Point guard");
		imageDTO.setImageId(1);
		imageService.saveImage(null, imageDTO);
	}

}
