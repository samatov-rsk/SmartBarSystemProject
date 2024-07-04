package com.samatov.inventoryservicebar.repositories;
import com.samatov.inventoryservicebar.entities.Liqueur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiqueurRepository extends MongoRepository<Liqueur, String> {

}
