package com.samatov.inventoryservicebar.controllers;


import com.samatov.inventoryservicebar.entities.Whisky;
import com.samatov.inventoryservicebar.services.WhiskyService;
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
@RequestMapping("api/v1/whisky")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WhiskyController {

    WhiskyService whiskyService;

    @GetMapping("/all")
    public ResponseEntity<List<Whisky>> getAllWhiskys() {
        List<Whisky> whiskies = whiskyService.getAllWhiskys();
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Whisky> getWhiskyById(@PathVariable String id) {
        return whiskyService.findWhiskyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveWhisky(@RequestBody Whisky whisky) {
        whiskyService.saveWhisky(whisky);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Whisky> updateWhiskyById(@PathVariable String id, Whisky whisky) {
        whiskyService.updateWhisky(id, whisky);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhiskyById(@PathVariable String id) {
        whiskyService.deleteWhiskyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Whisky> deleteAllWhiskys() {
        whiskyService.deleteAllWhiskys();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
