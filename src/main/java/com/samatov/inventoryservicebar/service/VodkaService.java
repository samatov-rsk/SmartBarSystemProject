package com.samatov.inventoryservicebar.service;

import com.samatov.inventoryservicebar.model.Vodka;
import com.samatov.inventoryservicebar.repository.VodkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class VodkaService  {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private VodkaRepository vodkaRepository;

    public List<Vodka> getAllVodkas() {
        logger.info("Всю позицию водки получили из база данных");
        return vodkaRepository.findAll();
    }

    public void saveVodka(Vodka vodka) {
        logger.info("Водка добавлена в базу данных");
        vodkaRepository.save(vodka);
    }

    public void deleteVodkaById(String id) {
        logger.info("Водка удалена из база данных");
        vodkaRepository.deleteById(id);
    }

    public void deleteAllVodkas() {
        logger.info("Вся позиция водки удалена из база данных");
        vodkaRepository.deleteAll();
    }

    public void updateVodka(String id, Vodka vodka) {
        Optional<Vodka> existingVodka = vodkaRepository.findById(id);
        if (existingVodka.isPresent()) {
            Vodka updatedVodka = existingVodka.get();
            updatedVodka.setName(vodka.getName());
            updatedVodka.setCountryOfOrigin(vodka.getCountryOfOrigin());
            updatedVodka.setColor(vodka.getColor());
            updatedVodka.setPrice(vodka.getPrice());
            updatedVodka.setVolume(vodka.getVolume());
            updatedVodka.setAcoholContent(vodka.getAcoholContent());
            logger.info("Водка изменилась в базе данных");
            vodkaRepository.save(updatedVodka);
        }
    }

    public Optional<Vodka> findVodkaById(String id) {
        try {
            return vodkaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти водку по ID " + e);
        }
    }
}
