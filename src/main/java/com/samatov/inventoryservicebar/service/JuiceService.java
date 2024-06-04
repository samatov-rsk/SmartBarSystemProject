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

    public List<Juice> getAllJuices() {
        return juiceRepository.findAll();
    }

    public void saveJuice(Juice juice) {
        juiceRepository.save(juice);
    }

    public void deleteBeerById(String id) {
        juiceRepository.deleteById(id);
    }

    public void deleteAllBeers() {
        juiceRepository.deleteAll();
    }

    public void updateJuice(Juice juice) {
        juiceRepository.save(juice);
    }

    public void findJuiceById(String id) {
        juiceRepository.findById(id);
    }
}
