package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Vodka;
import com.samatov.inventoryservicebar.repository.VodkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VodkaService  {

    @Autowired
    private VodkaRepository vodkaRepository;

    public List<Vodka> getAllVodkas() {
        return vodkaRepository.findAll();
    }

    public void saveVodka(Vodka vodka) {
        vodkaRepository.save(vodka);
    }

    public void deleteBeerById(String id) {
        vodkaRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        vodkaRepository.deleteAll();
    }

    public void updateVodka(Vodka vodka) {
        vodkaRepository.save(vodka);
    }

    public Optional<Vodka> findVodkaById(String id) {
        try {
            return vodkaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти водку по ID " + e);
        }
    }
}
