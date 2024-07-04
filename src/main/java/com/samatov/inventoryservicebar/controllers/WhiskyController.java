package com.samatov.inventoryservicebar.controllers;


import com.samatov.inventoryservicebar.entities.Whisky;
import com.samatov.inventoryservicebar.services.WhiskyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/whisky")
@RequiredArgsConstructor
public class WhiskyController {

    private final WhiskyService whiskyService;

    @GetMapping("/all")
    public ResponseEntity<List<Whisky>> getAllWhiskys(){
        List<Whisky> whiskies = whiskyService.getAllWhiskys();
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Whisky> getWhiskyById(@PathVariable String id){
        return whiskyService.findWhiskyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveWhisky(@RequestBody Whisky whisky){
        whiskyService.saveWhisky(whisky);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Whisky> updateWhiskyById(@PathVariable String id, Whisky whisky){
        whiskyService.updateWhisky(id,whisky);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhiskyById(@PathVariable String id){
        whiskyService.deleteWhiskyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Whisky> deleteAllWhiskys(){
        whiskyService.deleteAllWhiskys();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
