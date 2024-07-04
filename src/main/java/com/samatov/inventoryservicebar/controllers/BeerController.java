package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Beer;
import com.samatov.inventoryservicebar.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/all")
    public ResponseEntity<List<Beer>> getAllBeers(){
       List<Beer> beers =  beerService.getAllBeers();
        return new ResponseEntity<>(beers,HttpStatus.OK);
    }

    // Добавил проверку дабы избежать ошибки "NoSuchElementException" мало ли объект будет пуст
    @GetMapping("/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable String id){
        return beerService.findBeerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveBeer(@RequestBody Beer beer){
        beerService.saveBeer(beer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> updateBeerById(@PathVariable String id, Beer beer){
        beerService.updateBeer(id,beer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable String id){
        beerService.deleteBeerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Beer> deleteAllBeers(){
        beerService.deleteAllBeers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
