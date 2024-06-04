package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Wine;
import com.samatov.inventoryservicebar.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    // Метод для получение все пиво
    public List<Wine> getAllBeers() {
        return wineRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Wine wine) {
        wineRepository.save(wine);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        wineRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Wine wine) {
        wineRepository.save(wine);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        wineRepository.findById(id);
    }

}
