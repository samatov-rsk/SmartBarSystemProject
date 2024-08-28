package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.WhiskyNotFoundException;
import com.samatov.inventoryservicebar.dto.WhiskyDTO;
import com.samatov.inventoryservicebar.entities.WhiskyEntity;
import com.samatov.inventoryservicebar.mappers.WhiskyMapper;
import com.samatov.inventoryservicebar.repositories.WhiskyRepository;
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
public class WhiskyService {

    WhiskyRepository whiskyRepository;

    WhiskyMapper whiskyMapper;

    public List<WhiskyDTO> getAllWhiskys() {
        List<WhiskyEntity> whiskys = whiskyRepository.findAll();
        log.info("Получены все позиции виски из базы данных");
        if (whiskys.isEmpty()) {
            throw new WhiskyNotFoundException("Позиции виски не найдены в базе данных");
        }
        return whiskys.stream().map(whiskyMapper::toDto).collect(Collectors.toList());
    }

    public void saveWhisky(WhiskyDTO whiskyDTO) {
        WhiskyEntity whisky = whiskyMapper.toEntity(whiskyDTO);
        log.info("Добавление виски в базу данных");
        whiskyRepository.save(whisky);
    }

    public void deleteWhiskyById(String id) {
        log.info("Удаление виски из базы данных");
        if (!whiskyRepository.existsById(id)) {
            throw new WhiskyNotFoundException("Виски с данным идендификатором не найдено");
        }
        whiskyRepository.deleteById(id);
    }

    public void deleteAllWhiskys() {
        log.info("Удаление всех позиций виски из базы данных");
        whiskyRepository.deleteAll();
    }

    public void updateWhisky(String id, WhiskyDTO whiskyDTO) {
        Optional<WhiskyEntity> existingWhisky = whiskyRepository.findById(id);
        if (existingWhisky.isPresent()) {
            WhiskyEntity updatedWhisky = whiskyMapper.toEntity(whiskyDTO);
            updatedWhisky.setName(updatedWhisky.getName());
            updatedWhisky.setColor(updatedWhisky.getColor());
            updatedWhisky.setPrice(updatedWhisky.getPrice());
            updatedWhisky.setVolume(updatedWhisky.getVolume());
            updatedWhisky.setAlcoholContent(updatedWhisky.getAlcoholContent());
            log.info("Обновление виски в базе данных");
            whiskyRepository.save(updatedWhisky);
        } else {
            throw new WhiskyNotFoundException("Виски с данным идендификатором не найдено");
        }
    }

    public WhiskyDTO findWhiskyById(String id) {
        return whiskyRepository.findById(id)
                .map(whiskyMapper::toDto)
                .orElseThrow(() -> new WhiskyNotFoundException("Виски с данным идендификатором не найдено"));
    }
}
