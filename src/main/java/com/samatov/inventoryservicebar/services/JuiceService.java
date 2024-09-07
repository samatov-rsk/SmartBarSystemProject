package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.JuiceNotFoundException;
import com.samatov.inventoryservicebar.dto.JuiceDTO;
import com.samatov.inventoryservicebar.entities.JuiceEntity;
import com.samatov.inventoryservicebar.mappers.JuiceMapper;
import com.samatov.inventoryservicebar.repositories.JuiceRepository;
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
public class JuiceService {

    JuiceRepository juiceRepository;

    JuiceMapper juiceMapper;

    public List<JuiceDTO> getAllJuices() {
        List<JuiceEntity> juices = juiceRepository.findAll();
        log.info("Получены все позиции соков из база данных");
        if(juices.isEmpty()) {
            throw new JuiceNotFoundException("Позиции соков не найдены в базе данных");
        }
        return juices.stream().map(juiceMapper::toDto).collect(Collectors.toList());
    }

    public void saveJuice(JuiceDTO juiceDTO) {
        JuiceEntity juice = juiceMapper.toEntity(juiceDTO);
        log.info("Добавление сок в базу данных");
        juiceRepository.save(juice);
    }

    public void deleteJuiceById(String id) {
        log.info("Удаление сока из базы данных");
        if (!juiceRepository.existsById(id)) {
            throw new JuiceNotFoundException("Сок с данным идендификатором не найден");
        }
        juiceRepository.deleteById(id);
    }

    public void deleteAllJuices() {
        log.info("Удаление всех позиции сока из база данных");
        juiceRepository.deleteAll();
    }

    public void updateJuice(String id, JuiceDTO juiceDTO) {
        Optional<JuiceEntity> existingJuice = juiceRepository.findById(id);
        if (existingJuice.isPresent()) {
            JuiceEntity updatedJuice = juiceMapper.toEntity(juiceDTO);
            updatedJuice.setName(updatedJuice.getName());
            updatedJuice.setColor(updatedJuice.getColor());
            updatedJuice.setPrice(updatedJuice.getPrice());
            updatedJuice.setVolume(updatedJuice.getVolume());
            log.info("Обновление сока в базе данных");
            juiceRepository.save(updatedJuice);
        } else {
            throw new JuiceNotFoundException("Сок с данным идендификатором не найден");
        }
    }

    public JuiceDTO findJuiceById(String id) {
        return juiceRepository.findById(id)
                .map(juiceMapper::toDto)
                .orElseThrow(() -> new JuiceNotFoundException("Сок с данным идендификатором не найдено"));
    }
}
