package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Liqueur;
import com.samatov.inventoryservicebar.repository.LiqueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class LiqueurService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private LiqueurRepository liqueurRepository;

    public List<Liqueur> getAllLiqueurs() {
        logger.info("Всю позицию ликеров получили из база данных");
        return liqueurRepository.findAll();
    }

    public void saveLiqueur(Liqueur liqueur) {
        logger.info("Ликер добавлен в базу данных");
        liqueurRepository.save(liqueur);
    }

    public void deleteLiqueurById(String id) {
        logger.info("Ликер удален из база данных");
        liqueurRepository.deleteById(id);
    }

    public void deleteAllLiqueurs() {
        logger.info("Вся позиция ликеров удалена из база данных");
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
            logger.info("Ликер изменился в базе данных");
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
