package com.rubenskj.core.server.repository;

import com.rubenskj.core.server.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends MongoRepository<Image, String> {
}
