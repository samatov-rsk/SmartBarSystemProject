package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Beer;
import com.samatov.inventoryservicebar.services.BeerService;
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
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/all")
    public ResponseEntity<List<Beer>> getAllBeers(){
       List<Beer> beers =  beerService.getAllBeers();
        return new ResponseEntity<>(beers,HttpStatus.OK);
    }


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
