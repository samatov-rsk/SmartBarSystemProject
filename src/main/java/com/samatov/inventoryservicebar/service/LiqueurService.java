package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Liqueur;
import com.samatov.inventoryservicebar.repository.LiqueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiqueurService {

    @Autowired
    private LiqueurRepository liqueurRepository;

    public List<Liqueur> getAllLiqueurs() {
        return liqueurRepository.findAll();
    }

    public void saveLiqueur(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }

    public void deleteBeerById(String id) {
        liqueurRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        liqueurRepository.deleteAll();
    }

    public void updateLiqueur(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }

    public Optional<Liqueur> findLiqueurById(String id) {
        try {
            return liqueurRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти ликер по ID " + e);
        }
    }
}
