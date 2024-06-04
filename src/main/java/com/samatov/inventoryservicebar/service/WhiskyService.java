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

    public void findWhiskyById(String id) {
        whiskyRepository.findById(id);
    }
}
