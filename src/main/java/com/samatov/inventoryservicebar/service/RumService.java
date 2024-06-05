package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Rum;
import com.samatov.inventoryservicebar.repository.RumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RumService {

    @Autowired
    private RumRepository rumRepository;

    public List<Rum> getAllRums() {
        return rumRepository.findAll();
    }

    public void saveRum(Rum rum) {
        rumRepository.save(rum);
    }

    public void deleteBeerById(String id) {
        rumRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        rumRepository.deleteAll();
    }

    public void updateRum(Rum rum) {
        rumRepository.save(rum);
    }

    public Optional<Rum> findRumById(String id) {
        try {
            return rumRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти ром по ID " + e);
        }
    }
}
