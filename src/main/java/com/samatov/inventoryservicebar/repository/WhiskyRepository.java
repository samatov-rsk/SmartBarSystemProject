package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Whisky;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends MongoRepository<Whisky,String> {

}
