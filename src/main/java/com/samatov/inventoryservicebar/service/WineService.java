package com.samatov.inventoryservicebar.service;

import com.samatov.inventoryservicebar.model.Wine;
import com.samatov.inventoryservicebar.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class WineService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private WineRepository wineRepository;

    public List<Wine> getAllWines() {
        logger.info("Всю позицию вина получили из база данных");
        return wineRepository.findAll();
    }

    public void saveWine(Wine wine) {
        logger.info("Вино добавлено в базу данных");
        wineRepository.save(wine);
    }

    public void deleteWineById(String id) {
        logger.info("Вино удален из база данных");
        wineRepository.deleteById(id);
    }

    public void deleteAllWines() {
        logger.info("Вся позиция вина удалена из база данных");
        wineRepository.deleteAll();
    }

    public void updateWine(String id, Wine wine) {
        Optional<Wine> existingWine = wineRepository.findById(id);
        if (existingWine.isPresent()) {
            Wine updatedWine = existingWine.get();
            updatedWine.setName(wine.getName());
            updatedWine.setCountryOfOrigin(wine.getCountryOfOrigin());
            updatedWine.setColor(wine.getColor());
            updatedWine.setPrice(wine.getPrice());
            updatedWine.setVolume(wine.getVolume());
            updatedWine.setAcoholContent(wine.getAcoholContent());
            logger.info("Вино изменилось в базе данных");
            wineRepository.save(updatedWine);
        }
    }

    public Optional<Wine> findWineById(String id) {
        try {
            return wineRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти вино по ID " + e);
        }
    }
}
