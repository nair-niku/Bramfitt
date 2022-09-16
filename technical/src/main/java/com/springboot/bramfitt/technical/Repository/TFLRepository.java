package com.springboot.bramfitt.technical.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.bramfitt.technical.TFLInfo;

public interface TFLRepository extends MongoRepository<TFLInfo, String>{


}
