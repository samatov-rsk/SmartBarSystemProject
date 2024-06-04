package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Rum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RumRepository extends MongoRepository<Rum, String> {

}
