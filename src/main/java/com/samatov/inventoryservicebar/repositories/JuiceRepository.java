package com.samatov.inventoryservicebar.repositories;

import com.samatov.inventoryservicebar.entities.JuiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuiceRepository extends MongoRepository<JuiceEntity, String> {

}
