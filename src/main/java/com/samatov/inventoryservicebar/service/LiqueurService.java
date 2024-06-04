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

    // Метод для получение все пиво
    public List<Liqueur> getAllBeers() {
        return liqueurRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        liqueurRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Liqueur liqueur) {
        liqueurRepository.save(liqueur);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        liqueurRepository.findById(id);
    }

}
