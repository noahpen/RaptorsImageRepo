package com.noah.raptorsImageRepo.dao;

import org.springframework.data.repository.CrudRepository;

import com.noah.raptorsImageRepo.dto.ImageDTO;

public interface ImageRepository extends CrudRepository<ImageDTO, Integer> {


}
