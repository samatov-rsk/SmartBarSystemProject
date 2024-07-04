package com.samatov.inventoryservicebar.repositories;
import com.samatov.inventoryservicebar.entities.Cocktail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends MongoRepository<Cocktail, String> {

}
