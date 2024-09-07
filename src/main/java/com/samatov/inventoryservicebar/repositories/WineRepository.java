package com.samatov.inventoryservicebar.repositories;

import com.samatov.inventoryservicebar.entities.WineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends MongoRepository<WineEntity, String> {

}
