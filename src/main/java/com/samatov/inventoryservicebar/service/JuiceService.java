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

    // Метод для получение всех лимонадов
    public List<Juice> getAllJuices() {
        return juiceRepository.findAll();
    }
    // Метод для сохрание лимонадов
    public void saveJuice(Juice juice) {
        juiceRepository.save(juice);
    }
    // Метод для удаление всех соков по айдишнику
    public void deleteJuicesAllById() {
        juiceRepository.deleteAll();
    }
    // Метод для измененение лимонадов
    public void updateJuice(Juice juice) {
        juiceRepository.save(juice);
    }
    // Метод для нахождение лимонадов по айдишнику
    public void findJuiceById(String id) {
        juiceRepository.findById(id);
    }
}
