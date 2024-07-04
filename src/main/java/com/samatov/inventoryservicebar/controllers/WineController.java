package com.samatov.inventoryservicebar.controllers;


import com.samatov.inventoryservicebar.entities.Wine;
import com.samatov.inventoryservicebar.services.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wine")
@RequiredArgsConstructor
public class WineController {

    private final WineService wineService;

    @GetMapping("/all")
    public ResponseEntity<List<Wine>> getAllWines(){
        List<Wine> wines =  wineService.getAllWines();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wine> getWineById(@PathVariable String id){
        return wineService.findWineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveWine(@RequestBody Wine wine){
        wineService.saveWine(wine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wine> updateWineById(@PathVariable String id, Wine wine){
        wineService.updateWine(id,wine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWineById(@PathVariable String id){
        wineService.deleteWineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Wine> deleteAllWines(){
        wineService.deleteAllWines();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
