package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Vodka;
import com.samatov.inventoryservicebar.repository.VodkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VodkaService  {

    @Autowired
    private VodkaRepository vodkaRepository;

    // Метод для получение все водки
    public List<Vodka> getAllVodkas() {
        return vodkaRepository.findAll();
    }
    // Метод для сохрание водки
    public void saveVodka(Vodka vodka) {
        vodkaRepository.save(vodka);
    }
    // Метод для удаление все водки по айдишнику
    public void deleteVodkasAllById() {
        vodkaRepository.deleteAll();
    }
    // Метод для измененение водки
    public void updateVodka(Vodka vodka) {
        vodkaRepository.save(vodka);
    }
    // Метод для нахождение водки по айдишнику
    public void findVodkaById(String id) {
        vodkaRepository.findById(id);
    }
}
