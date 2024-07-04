package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Vodka;
import com.samatov.inventoryservicebar.repositories.VodkaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VodkaService  {

    private final VodkaRepository vodkaRepository;

    public List<Vodka> getAllVodkas() {
        log.info("Всю позицию водки получили из база данных");
        return vodkaRepository.findAll();
    }

    public void saveVodka(Vodka vodka) {
        log.info("Водка добавлена в базу данных");
        vodkaRepository.save(vodka);
    }

    public void deleteVodkaById(String id) {
        log.info("Водка удалена из база данных");
        vodkaRepository.deleteById(id);
    }

    public void deleteAllVodkas() {
        log.info("Вся позиция водки удалена из база данных");
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
            log.info("Водка изменилась в базе данных");
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
