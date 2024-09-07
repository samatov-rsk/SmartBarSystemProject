package com.samatov.inventoryservicebar.repositories;

import com.samatov.inventoryservicebar.entities.WhiskyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends MongoRepository<WhiskyEntity,String> {

}
