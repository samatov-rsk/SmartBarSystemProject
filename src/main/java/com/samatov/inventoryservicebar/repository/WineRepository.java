package com.samatov.inventoryservicebar.repository;

import com.samatov.inventoryservicebar.model.Wine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends MongoRepository<Wine, String> {

}
