package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {

    @Autowired
    private CocktailRepository cocktailRepository;

    // Метод для получение всех коктейли
    public List<Cocktail> getAllBeers() {
        return cocktailRepository.findAll();
    }
    // Метод для сохрание коктейли
    public void saveBeer(Cocktail cocktail) {
        cocktailRepository.save(cocktail);
    }
    // Метод для удаление всех коктейли по айдишнику
    public void deleteBeerAllById() {
        cocktailRepository.deleteAll();
    }
    // Метод для измененение состав т.д коктейли
    public void updateBeer(Cocktail cocktail) {
        cocktailRepository.save(cocktail);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        cocktailRepository.findById(id);
    }
}
