package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Whisky;
import com.samatov.inventoryservicebar.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhiskyService {

    @Autowired
    private WhiskyRepository whiskyRepository;

    public List<Whisky> getAllWhiskys() {
        return whiskyRepository.findAll();
    }

    public void saveWhisky(Whisky whisky) {
        whiskyRepository.save(whisky);
    }

    public void deleteBeerById(String id) {
        whiskyRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        whiskyRepository.deleteAll();
    }

    public void updateWhisky(Whisky whisky) {
        whiskyRepository.save(whisky);
    }

    public Optional<Whisky> findWhiskyById(String id) {
        try {
            return whiskyRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти виски по ID " + e);
        }
    }
}
