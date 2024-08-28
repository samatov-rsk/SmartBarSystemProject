package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.WhiskyDTO;
import com.samatov.inventoryservicebar.services.WhiskyService;
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
@RequestMapping("api/v1/whisky")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WhiskyController {

    WhiskyService whiskyService;

    @GetMapping("/all")
    public ResponseEntity<List<WhiskyDTO>> getAllWhiskys() {
        List<WhiskyDTO> whiskiesDto = whiskyService.getAllWhiskys();
        return new ResponseEntity<>(whiskiesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhiskyDTO> getWhiskyById(@PathVariable String id) {
       WhiskyDTO whiskyDto = whiskyService.findWhiskyById(id);
       return ResponseEntity.ok(whiskyDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveWhisky(@RequestBody @Valid WhiskyDTO whiskyDto) {
        whiskyService.saveWhisky(whiskyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhiskyDTO> updateWhiskyById(@PathVariable String id, @Valid WhiskyDTO whiskyDto) {
        whiskyService.updateWhisky(id, whiskyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhiskyById(@PathVariable String id) {
        whiskyService.deleteWhiskyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<WhiskyDTO> deleteAllWhiskys() {
        whiskyService.deleteAllWhiskys();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
