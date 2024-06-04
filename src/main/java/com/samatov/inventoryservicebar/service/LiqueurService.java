package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Liqueur;
import com.samatov.inventoryservicebar.repository.LiqueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiqueurService {

    @Autowired
    private LiqueurRepository liqueurRepository;

    // Метод для получение всех ликеров
    public List<Liqueur> getAllLiqueurs() {
        return liqueurRepository.findAll();
    }
    // Метод для сохрание ликеров
    public void saveLiqueur(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }
    // Метод для удаление всех ликеров по айдишнику
    public void deleteLiqueursAllById() {
        liqueurRepository.deleteAll();
    }
    // Метод для измененение ликеров
    public void updateLiqueur(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }
    // Метод для нахождение ликеров по айдишнику
    public void findLiqueurById(String id) {
        liqueurRepository.findById(id);
    }

}
