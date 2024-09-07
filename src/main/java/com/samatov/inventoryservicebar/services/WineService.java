package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.WineNotFoundException;
import com.samatov.inventoryservicebar.dto.WineDTO;
import com.samatov.inventoryservicebar.entities.WineEntity;
import com.samatov.inventoryservicebar.mappers.WineMapper;
import com.samatov.inventoryservicebar.repositories.WineRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WineService {

    WineRepository wineRepository;

    WineMapper wineMapper;

    public List<WineDTO> getAllWines() {
        List<WineEntity> wines = wineRepository.findAll();
        log.info("Получены все позиции вина из базы данных");
        if (wines.isEmpty()) {
            throw new WineNotFoundException("Позиции вина не найдены в базе данныхвщсл");
        }
        return wines.stream().map(wineMapper::toDto).collect(Collectors.toList());
    }

    public void saveWine(WineDTO wineDTO) {
        WineEntity wine = wineMapper.toEntity(wineDTO);
        log.info("Добавление вина в базу данных");
        wineRepository.save(wine);
    }

    public void deleteWineById(String id) {
        log.info("Удаление вина из базы данных");
        if (!wineRepository.existsById(id)) {
            throw new WineNotFoundException("Вино с данным идендификатором не найдено");
        }
        wineRepository.deleteById(id);
    }

    public void deleteAllWines() {
        log.info("Удаление всех позиций вина из базы данных");
        wineRepository.deleteAll();
    }

    public void updateWine(String id, WineDTO wineDTO) {
        Optional<WineEntity> existingWine = wineRepository.findById(id);
        if (existingWine.isPresent()) {
            WineEntity updatedWine = wineMapper.toEntity(wineDTO);
            updatedWine.setName(updatedWine.getName());
            updatedWine.setColor(updatedWine.getColor());
            updatedWine.setPrice(updatedWine.getPrice());
            updatedWine.setVolume(updatedWine.getVolume());
            updatedWine.setAlcoholContent(updatedWine.getAlcoholContent());
            updatedWine.setGrapeVariety(updatedWine.getGrapeVariety());
            log.info("Обновление вина в базе данных");
            wineRepository.save(updatedWine);
        } else {
            throw new WineNotFoundException("Вино с данным идендификатором не найдено");
        }
    }
        public WineDTO findWineById(String id) {
            return wineRepository.findById(id)
                    .map(wineMapper::toDto)
                    .orElseThrow(() -> new WineNotFoundException("Вино с данным идендификатором не найдено"));
        }
}
