package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.LiqueurDTO;
import com.samatov.inventoryservicebar.services.LiqueurService;
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
@RequestMapping("/api/v1/liqueur")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LiqueurControllers {

    LiqueurService liqueurService;

    @GetMapping("/all")
    public ResponseEntity<List<LiqueurDTO>> getAllLiqueurs() {
        List<LiqueurDTO> liqueursDto = liqueurService.getAllLiqueurs();
        return new ResponseEntity<>(liqueursDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiqueurDTO> getLiqueursById(@PathVariable String id) {
        LiqueurDTO liqueurDto = liqueurService.findLiqueurById(id);
        return ResponseEntity.ok(liqueurDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveLiqueur(@RequestBody @Valid LiqueurDTO liqueurDto) {
        liqueurService.saveLiqueur(liqueurDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LiqueurDTO> updateLiqueurById(@PathVariable String id, @Valid LiqueurDTO liqueurDto) {
        liqueurService.updateLiqueur(id, liqueurDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiqueurById(@PathVariable String id) {
        liqueurService.deleteLiqueurById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<LiqueurDTO> deleteAllLiqueurs() {
        liqueurService.deleteAllLiqueurs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
