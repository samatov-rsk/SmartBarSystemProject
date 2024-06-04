package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Juice;
import com.samatov.inventoryservicebar.repository.JuiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuiceService {

    @Autowired
    private JuiceRepository juiceRepository;

    // Метод для получение все пиво
    public List<Juice> getAllBeers() {
        return juiceRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Juice juice) {
        juiceRepository.save(juice);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        juiceRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Juice juice) {
        juiceRepository.save(juice);
    }
    // Метод для нахождение пиво по айдишнику // Почему сделал конверт ? Не удобно будет писать строки для id
    public void findBeerById(String id) {
        juiceRepository.findById(id);
    }
}
