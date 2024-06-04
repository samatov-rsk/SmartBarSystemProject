package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Vodka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VodkaRepository extends MongoRepository<Vodka, String> {

}
