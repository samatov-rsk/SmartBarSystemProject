package com.samatov.inventoryservicebar.repositories;
import com.samatov.inventoryservicebar.entities.Vodka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VodkaRepository extends MongoRepository<Vodka, String> {

}
