package com.samatov.inventoryservicebar.repository;
import com.samatov.inventoryservicebar.model.Cocktail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends MongoRepository<Cocktail, String> {

}
