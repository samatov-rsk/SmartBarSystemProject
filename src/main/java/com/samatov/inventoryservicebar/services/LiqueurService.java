package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.LiqueurNotFoundException;
import com.samatov.inventoryservicebar.dto.LiqueurDTO;
import com.samatov.inventoryservicebar.entities.LiqueurEntity;
import com.samatov.inventoryservicebar.mappers.LiqueurMapper;
import com.samatov.inventoryservicebar.repositories.LiqueurRepository;
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
public class LiqueurService {

    LiqueurRepository liqueurRepository;

    LiqueurMapper liqueurMapper;

    public List<LiqueurDTO> getAllLiqueurs() {
        List<LiqueurEntity> liqueurs = liqueurRepository.findAll();
        log.info("Получены все позиции ликеров из базы данных");
        if (liqueurs.isEmpty()) {
            throw new LiqueurNotFoundException("Позиции ликеров не найдены в базе данных");
        }
        return liqueurs.stream().map(liqueurMapper::toDto).collect(Collectors.toList());
    }

    public void saveLiqueur(LiqueurDTO liqueurDTO) {
        LiqueurEntity liqueur = liqueurMapper.toEntity(liqueurDTO);
        log.info("Добавление ликера в базу данных");
        liqueurRepository.save(liqueur);
    }

    public void deleteLiqueurById(String id) {
        log.info("Удаление ликера из базы данных");
        if (!liqueurRepository.existsById(id)) {
            throw new LiqueurNotFoundException("Ликер с данным идендификатором не найден");
        }
        liqueurRepository.deleteById(id);
    }

    public void deleteAllLiqueurs() {
        log.info("Удаление всех позиций ликера из базы данных");
        liqueurRepository.deleteAll();
    }

    public void updateLiqueur(String id, LiqueurDTO liqueurDTO) {
        Optional<LiqueurEntity> existingLiqueur = liqueurRepository.findById(id);
        if (existingLiqueur.isPresent()) {
            LiqueurEntity updatedLiqueur = liqueurMapper.toEntity(liqueurDTO);
            updatedLiqueur.setName(updatedLiqueur.getName());
            updatedLiqueur.setColor(updatedLiqueur.getColor());
            updatedLiqueur.setPrice(updatedLiqueur.getPrice());
            updatedLiqueur.setVolume(updatedLiqueur.getVolume());
            updatedLiqueur.setAlcoholContent(updatedLiqueur.getAlcoholContent());
            log.info("Обновление ликера в базе данных");
            liqueurRepository.save(updatedLiqueur);
        } else {
            throw new LiqueurNotFoundException("Ликер с данным идендификатором не найден");
        }
    }

    public LiqueurDTO findLiqueurById(String id) {
        return liqueurRepository.findById(id)
                .map(liqueurMapper::toDto)
                .orElseThrow(() -> new LiqueurNotFoundException("Ликер с данным идендификатором не найден"));
    }
}
