package com.samatov.inventoryservicebar.repositories;
import com.samatov.inventoryservicebar.entities.Rum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RumRepository extends MongoRepository<Rum, String> {

}
