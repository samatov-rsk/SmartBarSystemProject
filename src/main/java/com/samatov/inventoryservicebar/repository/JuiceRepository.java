package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Juice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuiceRepository extends MongoRepository<Juice, String> {

}
