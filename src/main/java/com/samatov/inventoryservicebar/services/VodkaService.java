package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.VodkaNotFoundException;
import com.samatov.inventoryservicebar.dto.VodkaDTO;
import com.samatov.inventoryservicebar.entities.VodkaEntity;
import com.samatov.inventoryservicebar.mappers.VodkaMapper;
import com.samatov.inventoryservicebar.repositories.VodkaRepository;
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
public class VodkaService {

    VodkaRepository vodkaRepository;

    VodkaMapper vodkaMapper;

    public List<VodkaDTO> getAllVodkas() {
        List<VodkaEntity> vodkas = vodkaRepository.findAll();
        log.info("Получены все позиции водки из базы данных");
        if (vodkas.isEmpty()) {
            throw new VodkaNotFoundException("Позиции водки не найдены в базе данных");
        }
        return vodkas.stream().map(vodkaMapper::toDto).collect(Collectors.toList());
    }

    public void saveVodka(VodkaDTO vodkaDTO) {
        VodkaEntity vodka = vodkaMapper.toEntity(vodkaDTO);
        log.info("Добавление водку в базу данных");
        vodkaRepository.save(vodka);
    }

    public void deleteVodkaById(String id) {
        log.info("Удаление водку из базы данных");
        if (!vodkaRepository.existsById(id)) {
            throw new VodkaNotFoundException("Водка с данным идендификатором не найдено");
        }
        vodkaRepository.deleteById(id);
    }

    public void deleteAllVodkas() {
        log.info("Удаление всех позиций водки из базы данных");
        vodkaRepository.deleteAll();
    }

    public void updateVodka(String id, VodkaDTO vodkaDTO) {
        Optional<VodkaEntity> existingVodka = vodkaRepository.findById(id);
        if (existingVodka.isPresent()) {
            VodkaEntity updatedVodka = vodkaMapper.toEntity(vodkaDTO);
            updatedVodka.setName(updatedVodka.getName());
            updatedVodka.setColor(updatedVodka.getColor());
            updatedVodka.setPrice(updatedVodka.getPrice());
            updatedVodka.setVolume(updatedVodka.getVolume());
            updatedVodka.setAlcoholContent(updatedVodka.getAlcoholContent());
            log.info("Обновление водки в базе данных");
            vodkaRepository.save(updatedVodka);
        } else {
            throw new VodkaNotFoundException("Водка с данным идендификатором не найдено");
        }
    }

    public VodkaDTO findVodkaById(String id) {
        return vodkaRepository.findById(id)
                .map(vodkaMapper::toDto)
                .orElseThrow(() -> new VodkaNotFoundException("Водка с данным идендификатором не найдено"));
    }
}
