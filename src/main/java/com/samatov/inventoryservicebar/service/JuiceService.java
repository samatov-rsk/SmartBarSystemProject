package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Juice;
import com.samatov.inventoryservicebar.repository.JuiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class JuiceService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private JuiceRepository juiceRepository;

    public List<Juice> getAllJuices() {
        logger.info("Всю позицию соков получили из база данных");
        return juiceRepository.findAll();
    }

    public void saveJuice(Juice juice) {
        logger.info("Сок добавлен в базу данных");
        juiceRepository.save(juice);
    }

    public void deleteJuiceById(String id) {
        logger.info("Сок удален из база данных");
        juiceRepository.deleteById(id);
    }

    public void deleteAllJuice() {
        logger.info("Вся позиция соков удалена из база данных");
        juiceRepository.deleteAll();
    }

    public void updateJuice(String id, Juice juice) {
        Optional<Juice> existingJuice = juiceRepository.findById(id);
        if (existingJuice.isPresent()) {
            Juice updatedJuice = existingJuice.get();
            updatedJuice.setName(juice.getName());
            updatedJuice.setCountryOfOrigin(juice.getCountryOfOrigin());
            updatedJuice.setColor(juice.getColor());
            updatedJuice.setPrice(juice.getPrice());
            updatedJuice.setVolume(juice.getVolume());
            logger.info("Сок изменился в базе данных");
            juiceRepository.save(updatedJuice);
        }
    }

    public Optional<Juice> findJuiceById(String id) {
        try {
            return juiceRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти сок по ID " + e);
        }
    }
}
