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

    public void findWineById(String id) {
        wineRepository.findById(id);
    }
}
