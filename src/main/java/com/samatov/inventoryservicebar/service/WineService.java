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

    // Метод для получение все вино
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }
    // Метод для сохрание вина
    public void saveWine(Wine wine) {
        wineRepository.save(wine);
    }
    // Метод для удаление все вина по айдишнику
    public void deleteWinesAllById() {
        wineRepository.deleteAll();
    }
    // Метод для измененение вина
    public void updateWine(Wine wine) {
        wineRepository.save(wine);
    }
    // Метод для нахождение вина по айдишнику
    public void findWineById(String id) {
        wineRepository.findById(id);
    }

}
