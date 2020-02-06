package com.noah.raptorsImageRepo.dao;

import com.noah.raptorsImageRepo.dto.ImageDTO;

public interface IImageDAO {

	void save(ImageDTO imageDTO) throws Exception;

	Iterable<ImageDTO> fetchAll() throws Exception;

	void delete(int imageId) throws Exception;
	
}
