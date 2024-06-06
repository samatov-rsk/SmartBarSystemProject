package com.samatov.inventoryservicebar.controller;

import com.samatov.inventoryservicebar.model.Beer;
import com.samatov.inventoryservicebar.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Beer>> getAllBeers(){
       List<Beer> beers =  beerService.getAllBeers();
        return new ResponseEntity<>(beers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable String id){
        Optional<Beer> beer = beerService.findBeerById(id);
        return new ResponseEntity<>(beer.get(),HttpStatus.OK);
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
