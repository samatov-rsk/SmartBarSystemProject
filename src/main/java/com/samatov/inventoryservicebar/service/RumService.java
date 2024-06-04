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

    // Метод для получение всех ромов
    public List<Rum> getAllRums() {
        return rumRepository.findAll();
    }
    // Метод для сохрание ромов
    public void saveRum(Rum rum) {
        rumRepository.save(rum);
    }
    // Метод для удаление всех ромов по айдишнику
    public void deleteRumsAllById() {
        rumRepository.deleteAll();
    }
    // Метод для измененение ромов
    public void updateRum(Rum rum) {
        rumRepository.save(rum);
    }
    // Метод для нахождение рома по айдишнику
    public void findRumById(String id) {
        rumRepository.findById(id);
    }
}
