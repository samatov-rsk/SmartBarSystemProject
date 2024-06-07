package com.samatov.inventoryservicebar.service;

import com.samatov.inventoryservicebar.model.Whisky;
import com.samatov.inventoryservicebar.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class WhiskyService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private WhiskyRepository whiskyRepository;

    public List<Whisky> getAllWhiskys() {
        logger.info("Всю позицию виски получили из база данных");
        return whiskyRepository.findAll();
    }

    public void saveWhisky(Whisky whisky) {
        logger.info("Виски добавлен в базу данных");
        whiskyRepository.save(whisky);
    }

    public void deleteWhiskyById(String id) {
        logger.info("Виски удалено из база данных");
        whiskyRepository.deleteById(id);
    }

    public void deleteAllWhiskys() {
        logger.info("Вся позиция виски удалена из база данных");
        whiskyRepository.deleteAll();
    }

    public void updateWhisky(String id, Whisky whisky) {
        Optional<Whisky> existingWhisky = whiskyRepository.findById(id);
        if (existingWhisky.isPresent()) {
            Whisky updatedWhisky = existingWhisky.get();
            updatedWhisky.setName(whisky.getName());
            updatedWhisky.setCountryOfOrigin(whisky.getCountryOfOrigin());
            updatedWhisky.setColor(whisky.getColor());
            updatedWhisky.setPrice(whisky.getPrice());
            updatedWhisky.setVolume(whisky.getVolume());
            updatedWhisky.setAcoholContent(whisky.getAcoholContent());
            logger.info("Виски изменилось в базе данных");
            whiskyRepository.save(updatedWhisky);
        }
    }

    public Optional<Whisky> findWhiskyById(String id) {
        try {
            return whiskyRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти виски по ID " + e);
        }
    }
}
