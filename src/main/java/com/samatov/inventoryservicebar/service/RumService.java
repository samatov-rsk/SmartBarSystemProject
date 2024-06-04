package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Rum;
import com.samatov.inventoryservicebar.repository.RumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RumService {

    @Autowired
    private RumRepository rumRepository;

    // Метод для получение все пиво
    public List<Rum> getAllBeers() {
        return rumRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Rum rum) {
        rumRepository.save(rum);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        rumRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Rum rum) {
        rumRepository.save(rum);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        rumRepository.findById(id);
    }
}
