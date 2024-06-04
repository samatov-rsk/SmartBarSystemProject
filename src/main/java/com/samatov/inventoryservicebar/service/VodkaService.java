package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Vodka;
import com.samatov.inventoryservicebar.repository.VodkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VodkaService  {

    @Autowired
    private VodkaRepository vodkaRepository;

    // Метод для получение все пиво
    public List<Vodka> getAllBeers() {
        return vodkaRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Vodka vodka) {
        vodkaRepository.save(vodka);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        vodkaRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Vodka vodka) {
        vodkaRepository.save(vodka);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        vodkaRepository.findById(id);
    }
}
