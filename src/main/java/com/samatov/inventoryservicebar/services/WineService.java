package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Wine;
import com.samatov.inventoryservicebar.repositories.WineRepository;
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
public class WineService {

    WineRepository wineRepository;

    public List<Wine> getAllWines() {
        log.info("Всю позицию вина получили из база данных");
        return wineRepository.findAll();
    }

    public void saveWine(Wine wine) {
        log.info("Вино добавлено в базу данных");
        wineRepository.save(wine);
    }

    public void deleteWineById(String id) {
        log.info("Вино удален из база данных");
        wineRepository.deleteById(id);
    }

    public void deleteAllWines() {
        log.info("Вся позиция вина удалена из база данных");
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
            updatedWine.setGrapeVariety(wine.getGrapeVariety());
            log.info("Вино изменилось в базе данных");
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
