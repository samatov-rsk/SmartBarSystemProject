package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Whisky;
import com.samatov.inventoryservicebar.repositories.WhiskyRepository;
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
public class WhiskyService {

    WhiskyRepository whiskyRepository;

    public List<Whisky> getAllWhiskys() {
        log.info("Всю позицию виски получили из база данных");
        return whiskyRepository.findAll();
    }

    public void saveWhisky(Whisky whisky) {
        log.info("Виски добавлен в базу данных");
        whiskyRepository.save(whisky);
    }

    public void deleteWhiskyById(String id) {
        log.info("Виски удалено из база данных");
        whiskyRepository.deleteById(id);
    }

    public void deleteAllWhiskys() {
        log.info("Вся позиция виски удалена из база данных");
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
            log.info("Виски изменилось в базе данных");
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
