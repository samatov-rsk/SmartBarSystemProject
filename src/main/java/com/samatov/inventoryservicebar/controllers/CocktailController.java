package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.CocktailDTO;
import com.samatov.inventoryservicebar.services.CocktailService;
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
@RequestMapping("/api/v1/cocktail")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CocktailController {

        CocktailService cocktailService;

        @GetMapping("/all")
        public ResponseEntity<List<CocktailDTO>> getAllCocktails() {
            List<CocktailDTO> cocktailsDto = cocktailService.getAllCocktails();
            return new ResponseEntity<>(cocktailsDto, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CocktailDTO> getCocktailById(@PathVariable String id) {
            CocktailDTO cocktailDto = cocktailService.findCocktailById(id);
            return ResponseEntity.ok(cocktailDto);
        }

        @PostMapping("/add")
        public ResponseEntity<Void> saveCocktail(@RequestBody  @Valid CocktailDTO cocktailDto) {
            cocktailService.saveCocktail(cocktailDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CocktailDTO> updateCocktailById(@PathVariable String id, @Valid CocktailDTO cocktailDto) {
            cocktailService.updateCocktail(id, cocktailDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCocktailById(@PathVariable String id) {
            cocktailService.deleteCocktailById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/delete/all")
        public ResponseEntity<CocktailDTO> deleteAllCocktail() {
            cocktailService.deleteAllCocktails();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
