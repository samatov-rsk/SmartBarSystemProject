package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Cocktail;
import com.samatov.inventoryservicebar.services.CocktailService;
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
