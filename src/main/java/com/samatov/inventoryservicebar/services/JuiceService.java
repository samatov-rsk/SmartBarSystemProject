package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Juice;
import com.samatov.inventoryservicebar.repositories.JuiceRepository;
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
public class JuiceService {


    JuiceRepository juiceRepository;

    public List<Juice> getAllJuices() {
        log.info("Всю позицию соков получили из база данных");
        return juiceRepository.findAll();
    }

    public void saveJuice(Juice juice) {
        log.info("Сок добавлен в базу данных");
        juiceRepository.save(juice);
    }

    public void deleteJuiceById(String id) {
        log.info("Сок удален из база данных");
        juiceRepository.deleteById(id);
    }

    public void deleteAllJuices() {
        log.info("Вся позиция соков удалена из база данных");
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
            log.info("Сок изменился в базе данных");
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
