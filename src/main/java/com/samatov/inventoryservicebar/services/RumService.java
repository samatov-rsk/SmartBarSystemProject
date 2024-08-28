package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.RumNotFoundException;
import com.samatov.inventoryservicebar.dto.RumDTO;
import com.samatov.inventoryservicebar.entities.RumEntity;
import com.samatov.inventoryservicebar.mappers.RumMapper;
import com.samatov.inventoryservicebar.repositories.RumRepository;
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
public class RumService {

    RumRepository rumRepository;

    RumMapper rumMapper;

    public List<RumDTO> getAllRums() {
        List<RumEntity> rums = rumRepository.findAll();
        log.info("Получены все позиции рома из базы данных");
        if (rums.isEmpty()) {
            throw new RumNotFoundException("Позиции рома не найдены в базе данных");
        }
        return rums.stream().map(rumMapper::toDto).collect(Collectors.toList());
    }

    public void saveRum(RumDTO rumDTO) {
        RumEntity rum = rumMapper.toEntity(rumDTO);
        log.info("Добавление рома в базу данных");
        rumRepository.save(rum);
    }

    public void deleteRumById(String id) {
        log.info("Удаление рома из базы данных");
        if (!rumRepository.existsById(id)) {
            throw new RumNotFoundException("Ром с данным идендификатором не найден");
        }
        rumRepository.deleteById(id);
    }

    public void deleteAllRums() {
        log.info("Удаление всех позиций рома из базы данных");
        rumRepository.deleteAll();
    }

    public void updateRum(String id, RumDTO rumDTO) {
        Optional<RumEntity> existingRum = rumRepository.findById(id);
        if (existingRum.isPresent()) {
            RumEntity updatedRum = rumMapper.toEntity(rumDTO);
            updatedRum.setName(updatedRum.getName());
            updatedRum.setColor(updatedRum.getColor());
            updatedRum.setPrice(updatedRum.getPrice());
            updatedRum.setVolume(updatedRum.getVolume());
            updatedRum.setAlcoholContent(updatedRum.getAlcoholContent());
            log.info("Обновление рома в базе данных");
            rumRepository.save(updatedRum);
        } else {
            throw new RumNotFoundException("Ром с данным идендификатором не найден");
        }
    }

    public RumDTO findRumById(String id) {
        return rumRepository.findById(id)
                .map(rumMapper::toDto)
                .orElseThrow(() -> new RumNotFoundException("Ром с данным идендификатором не найден"));
    }
}
