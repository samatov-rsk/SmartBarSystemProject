package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Rum;
import com.samatov.inventoryservicebar.repository.RumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RumService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private RumRepository rumRepository;

    public List<Rum> getAllRums() {
        logger.info("Всю позицию рома получили из база данных");
        return rumRepository.findAll();
    }

    public void saveRum(Rum rum) {
        logger.info("Ром добавлен в базу данных");
        rumRepository.save(rum);
    }

    public void deleteRumById(String id) {
        logger.info("Ром удален из база данных");
        rumRepository.deleteById(id);
    }

    public void deleteAllRums() {
        logger.info("Вся позиция рома удалена из база данных");
        rumRepository.deleteAll();
    }

    public void updateRum(String id, Rum rum) {
        Optional<Rum> existingRum = rumRepository.findById(id);
        if (existingRum.isPresent()) {
            Rum updatedRum = existingRum.get();
            updatedRum.setName(rum.getName());
            updatedRum.setCountryOfOrigin(rum.getCountryOfOrigin());
            updatedRum.setColor(rum.getColor());
            updatedRum.setPrice(rum.getPrice());
            updatedRum.setVolume(rum.getVolume());
            updatedRum.setAcoholContent(rum.getAcoholContent());
            logger.info("Ром изменился в базе данных");
            rumRepository.save(updatedRum);
        }
    }

    public Optional<Rum> findRumById(String id) {
        try {
            return rumRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти ром по ID " + e);
        }
    }
}
