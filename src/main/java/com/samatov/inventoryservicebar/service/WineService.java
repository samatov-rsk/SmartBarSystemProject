package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Wine;
import com.samatov.inventoryservicebar.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    public void saveWine(Wine wine) {
        wineRepository.save(wine);
    }

    public void deleteBeerById(String id) {
        wineRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        wineRepository.deleteAll();
    }

    public void updateWine(Wine wine) {
        wineRepository.save(wine);
    }

    public Optional<Wine> findWineById(String id) {
        try {
            return wineRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти вино по ID " + e);
        }
    }
}
