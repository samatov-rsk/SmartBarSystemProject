package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CocktailService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private CocktailRepository cocktailRepository;

    public List<Cocktail> getAllCocktails() {
        logger.info("Всю позицию коктейлей получили из база данных");
        return cocktailRepository.findAll();
    }

    public void saveCocktail(Cocktail cocktail) {
        logger.info("Коктейль добавлен в базу данных");
        cocktailRepository.save(cocktail);
    }

    public void deleteCocktailById(String id) {
        logger.info("Коктейль удален из база данных");
        cocktailRepository.deleteById(id);
    }

    public void deleteAllCocktail() {
        logger.info("Вся позиция коктейлей удалена из база данных");
        cocktailRepository.deleteAll();
    }

    public void updateCocktail(String id, Cocktail cocktail) {
        Optional<Cocktail> existingCocktail = cocktailRepository.findById(id);
        if (existingCocktail.isPresent()) {
            Cocktail updatedCocktail = existingCocktail.get();
            updatedCocktail.setName(cocktail.getName());
            updatedCocktail.setCountryOfOrigin(cocktail.getCountryOfOrigin());
            updatedCocktail.setColor(cocktail.getColor());
            updatedCocktail.setPrice(cocktail.getPrice());
            updatedCocktail.setVolume(cocktail.getVolume());
            updatedCocktail.setAcoholContent(cocktail.getAcoholContent());
            updatedCocktail.setIngredients(cocktail.getIngredients());
            logger.info("Коктейль изменился в базе данных");
            cocktailRepository.save(updatedCocktail);
        }
    }

    public Optional<Cocktail> findCoktailById(String id) {
        try {
            return cocktailRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти коктейль по ID " + e);
        }
    }
}
