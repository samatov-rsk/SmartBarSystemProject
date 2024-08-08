package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.entities.Liqueur;
import com.samatov.inventoryservicebar.repositories.LiqueurRepository;
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
public class LiqueurService {

    LiqueurRepository liqueurRepository;

    public List<Liqueur> getAllLiqueurs() {
        log.info("Всю позицию ликеров получили из база данных");
        return liqueurRepository.findAll();
    }

    public void saveLiqueur(Liqueur liqueur) {
        log.info("Ликер добавлен в базу данных");
        liqueurRepository.save(liqueur);
    }

    public void deleteLiqueurById(String id) {
        log.info("Ликер удален из база данных");
        liqueurRepository.deleteById(id);
    }

    public void deleteAllLiqueurs() {
        log.info("Вся позиция ликеров удалена из база данных");
        liqueurRepository.deleteAll();
    }

    public void updateLiqueur(String id, Liqueur liqueur) {
        Optional<Liqueur> existingLiqueur = liqueurRepository.findById(id);
        if (existingLiqueur.isPresent()) {
            Liqueur updatedLiqueur = existingLiqueur.get();
            updatedLiqueur.setName(liqueur.getName());
            updatedLiqueur.setCountryOfOrigin(liqueur.getCountryOfOrigin());
            updatedLiqueur.setColor(liqueur.getColor());
            updatedLiqueur.setPrice(liqueur.getPrice());
            updatedLiqueur.setVolume(liqueur.getVolume());
            updatedLiqueur.setAcoholContent(liqueur.getAcoholContent());
            log.info("Ликер изменился в базе данных");
            liqueurRepository.save(updatedLiqueur);
        }
    }

    public Optional<Liqueur> findLiqueurById(String id) {
        try {
            return liqueurRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти ликер по ID " + e);
        }
    }
}
