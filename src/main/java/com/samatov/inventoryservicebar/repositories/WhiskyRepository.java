package com.samatov.inventoryservicebar.repositories;
import com.samatov.inventoryservicebar.entities.Whisky;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends MongoRepository<Whisky,String> {

}
