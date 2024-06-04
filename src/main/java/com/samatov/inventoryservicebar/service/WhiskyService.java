package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Whisky;
import com.samatov.inventoryservicebar.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhiskyService {

    @Autowired
    private WhiskyRepository whiskyRepository;

    // Метод для получение все пиво
    public List<Whisky> getAllBeers() {
        return whiskyRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Whisky whisky) {
        whiskyRepository.save(whisky);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        whiskyRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Whisky whisky) {
        whiskyRepository.save(whisky);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        whiskyRepository.findById(id);
    }

}
