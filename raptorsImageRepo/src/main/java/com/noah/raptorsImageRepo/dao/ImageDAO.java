package com.noah.raptorsImageRepo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noah.raptorsImageRepo.dto.ImageDTO;

@Component
public class ImageDAO implements IImageDAO {

	@Autowired
	ImageRepository imageRepository;

	@Override
	public void save(ImageDTO imageDTO) throws Exception {
		// TODO Auto-generated method stub
		imageRepository.save(imageDTO);
	}
	
	@Override
	public Iterable<ImageDTO> fetchAll() throws Exception {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}
	
	@Override
	public void delete(int imageId) throws Exception {
		// TODO Auto-generated method stub
		imageRepository.deleteById(imageId);
	}
	
}
