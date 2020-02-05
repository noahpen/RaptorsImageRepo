package com.noah.raptorsImageRepo.dao;

import com.noah.raptorsImageRepo.dto.ImageDTO;

public interface IImageDAO {

	boolean save(ImageDTO imageDTO) throws Exception;

	Iterable<ImageDTO> fetchAll() throws Exception;
	
}
