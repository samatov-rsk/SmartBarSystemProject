package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.WineDTO;
import com.samatov.inventoryservicebar.services.WineService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/wine")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WineController {

     WineService wineService;

    @GetMapping("/all")
    public ResponseEntity<List<WineDTO>> getAllWines(){
        List<WineDTO> winesDto =  wineService.getAllWines();
        return new ResponseEntity<>(winesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineDTO> getWineById(@PathVariable String id){
       WineDTO wineDto = wineService.findWineById(id);
       return ResponseEntity.ok(wineDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveWine(@RequestBody @Valid WineDTO wineDto){
        wineService.saveWine(wineDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WineDTO> updateWineById(@PathVariable String id, @Valid WineDTO wineDto){
        wineService.updateWine(id, wineDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWineById(@PathVariable String id){
        wineService.deleteWineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<WineDTO> deleteAllWines(){
        wineService.deleteAllWines();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
