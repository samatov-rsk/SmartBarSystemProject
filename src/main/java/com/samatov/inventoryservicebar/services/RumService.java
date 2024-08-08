package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Rum;
import com.samatov.inventoryservicebar.repositories.RumRepository;
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
public class RumService {

    RumRepository rumRepository;

    public List<Rum> getAllRums() {
        log.info("Всю позицию рома получили из база данных");
        return rumRepository.findAll();
    }

    public void saveRum(Rum rum) {
        log.info("Ром добавлен в базу данных");
        rumRepository.save(rum);
    }

    public void deleteRumById(String id) {
        log.info("Ром удален из база данных");
        rumRepository.deleteById(id);
    }

    public void deleteAllRums() {
        log.info("Вся позиция рома удалена из база данных");
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
            log.info("Ром изменился в базе данных");
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
