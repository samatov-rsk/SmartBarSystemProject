package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Cocktail;
import com.samatov.inventoryservicebar.repositories.CocktailRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CocktailService {

    CocktailRepository cocktailRepository;

    public List<Cocktail> getAllCocktails() {
        log.info("Всю позицию коктейлей получили из база данных");
        return cocktailRepository.findAll();
    }

    public void saveCocktail(Cocktail cocktail) {
        log.info("Коктейль добавлен в базу данных");
        cocktailRepository.save(cocktail);
    }

    public void deleteCocktailById(String id) {
        log.info("Коктейль удален из база данных");
        cocktailRepository.deleteById(id);
    }

    public void deleteAllCocktails() {
        log.info("Вся позиция коктейлей удалена из база данных");
        cocktailRepository.deleteAll();
    }

    public void updateCocktail(String id, Cocktail cocktail) {
        Optional<Cocktail> existingCocktail = cocktailRepository.findById(id);
        if (existingCocktail.isPresent()) {
            Cocktail updatedCocktail = existingCocktail.get();
            updatedCocktail.setName(cocktail.getName());
            updatedCocktail.setColor(cocktail.getColor());
            updatedCocktail.setPrice(cocktail.getPrice());
            updatedCocktail.setVolume(cocktail.getVolume());
            updatedCocktail.setAcoholContent(cocktail.getAcoholContent());
            updatedCocktail.setIngredients(cocktail.getIngredients());
            log.info("Коктейль изменился в базе данных");
            cocktailRepository.save(updatedCocktail);
        }
    }

    public Optional<Cocktail> findCocktailById(String id) {
        try {
            return cocktailRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти коктейль по ID " + e);
        }
    }
}
