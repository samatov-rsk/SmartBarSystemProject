package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Beer;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocktailService {

    @Autowired
    private CocktailRepository cocktailRepository;

    public List<Cocktail> getAllCocktails() {
        return cocktailRepository.findAll();
    }

    public void saveCocktail(Cocktail cocktail) {
        cocktailRepository.save(cocktail);
    }

    public void deleteBeerById(String id) {
        cocktailRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        cocktailRepository.deleteAll();
    }

    public void updateCocktail(Cocktail cocktail) {
        cocktailRepository.save(cocktail);
    }

    public Optional<Cocktail> findCoktailById(String id) {
        try {
            return cocktailRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти коктейль по ID " + e);
        }
    }
}
