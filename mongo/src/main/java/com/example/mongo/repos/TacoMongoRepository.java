package com.example.mongo.repos;

import com.example.mongo.model.TacoOrderMongoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoMongoRepository extends CrudRepository<TacoOrderMongoDto, String> {
}
