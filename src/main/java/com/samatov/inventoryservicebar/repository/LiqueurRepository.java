package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Liqueur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiqueurRepository extends MongoRepository<Liqueur, String> {

}
