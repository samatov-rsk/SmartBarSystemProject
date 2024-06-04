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

    // Метод для получение всех виски
    public List<Whisky> getAllWhiskys() {
        return whiskyRepository.findAll();
    }
    // Метод для сохрание виски
    public void saveWhisky(Whisky whisky) {
        whiskyRepository.save(whisky);
    }
    // Метод для удаление все виски по айдишнику
    public void deleteWhiskysAllById() {
        whiskyRepository.deleteAll();
    }
    // Метод для измененение виски
    public void updateWhisky(Whisky whisky) {
        whiskyRepository.save(whisky);
    }
    // Метод для нахождение виски по айдишнику
    public void findWhiskyById(String id) {
        whiskyRepository.findById(id);
    }

}
