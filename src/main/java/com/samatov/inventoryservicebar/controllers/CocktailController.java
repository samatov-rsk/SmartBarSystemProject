package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Cocktail;
import com.samatov.inventoryservicebar.services.CocktailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cocktail")
@RequiredArgsConstructor
public class CocktailController {

        private final CocktailService cocktailService;

        @GetMapping("/all")
        public ResponseEntity<List<Cocktail>> getAllCocktails() {
            List<Cocktail> cocktails = cocktailService.getAllCocktails();
            return new ResponseEntity<>(cocktails, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Cocktail> getCocktailById(@PathVariable String id) {
            return cocktailService.findCocktailById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/add")
        public ResponseEntity<Void> saveCocktail(@RequestBody Cocktail cocktail) {
            cocktailService.saveCocktail(cocktail);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cocktail> updateCocktailById(@PathVariable String id, Cocktail cocktail) {
            cocktailService.updateCocktail(id, cocktail);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCocktailById(@PathVariable String id) {
            cocktailService.deleteCocktailById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/delete/all")
        public ResponseEntity<Cocktail> deleteAllCocktail() {
            cocktailService.deleteAllCocktails();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
