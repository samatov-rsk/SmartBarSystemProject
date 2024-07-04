package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Liqueur;
import com.samatov.inventoryservicebar.services.LiqueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/liqueur")
@RequiredArgsConstructor
public class LiqueurControllers {

    private final LiqueurService liqueurService;

    @GetMapping("/all")
    public ResponseEntity<List<Liqueur>> getAllLiqueurs(){
        List<Liqueur> liqueurs =  liqueurService.getAllLiqueurs();
        return new ResponseEntity<>(liqueurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Liqueur> getLiqueursById(@PathVariable String id){
        return liqueurService.findLiqueurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveLiqueur(@RequestBody Liqueur liqueur){
        liqueurService.saveLiqueur(liqueur);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Liqueur> updateLiqueurById(@PathVariable String id, Liqueur liqueur){
        liqueurService.updateLiqueur(id, liqueur);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiqueurById(@PathVariable String id){
        liqueurService.deleteLiqueurById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Liqueur> deleteAllLiqueurs(){
        liqueurService.deleteAllLiqueurs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
